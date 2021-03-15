package com.me.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DataSource source;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    public JdbcUtils() {
    }

    public static Connection getConnection() {
        Connection conn = conns.get();
        if(conn == null) {
            try {
                conn = source.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    public static void commitAndClose() {
        Connection conn = conns.get();
        if(conn != null) {
            try {
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                conns.remove();
            }
        }
    }

    public static void rollbackAndClose() {
        Connection conn = conns.get();
        if(conn != null) {
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                conns.remove();
            }
        }
    }

    static {
        try {
            Properties pros = new Properties();
            InputStream is = new FileInputStream("D:\\code\\java\\javaWeb\\book\\src\\main\\resources\\jdbc.properties");
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

}