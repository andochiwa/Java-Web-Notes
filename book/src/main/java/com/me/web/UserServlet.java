package com.me.web;

import com.google.gson.Gson;
import com.me.pojo.User;
import com.me.service.UserService;
import com.me.service.impl.UserServiceImpl;
import com.me.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.销毁session
        request.getSession().invalidate();
        // 2.重定向到首页
        response.sendRedirect(request.getContextPath());
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        User loginUser = userService.login(user);
        if (loginUser == null) {
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", user.getUsername());
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("user", loginUser);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    protected void ajaxExistUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean existsUserName = userService.existsUserName(username);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUserName", existsUserName);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        response.getWriter().write(json);
    }


    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求的参数
        String code = request.getParameter("code");

        // 使用注入
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        // 2.检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            // 3.检查用户名是否可用
            if (userService.existsUserName(user.getUsername())) {
                request.setAttribute("msg", "用户名已存在");
                request.setAttribute("username", user.getUsername());
                request.setAttribute("email", user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                // 4.可用，调用service保存到数据库
                userService.registUser(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("username", user.getUsername());
            request.setAttribute("email", user.getEmail());
            request.setAttribute("msg", "验证码错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }

//        // 1.获取请求的参数
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
//
//
//        // 2.检查验证码是否正确 === 暂时写死,要求abcd
//        if ("abcd".equalsIgnoreCase(code)) {
//            // 3.检查用户名是否可用
//            if (userService.existsUserName(username)) {
//                request.setAttribute("msg", "用户名已存在");
//                request.setAttribute("username", username);
//                request.setAttribute("email", email);
//                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
//            } else {
//                // 4.可用，调用service保存到数据库
//                userService.registUser(new User(null, username, password, email));
//                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
//            }
//        } else {
//            request.setAttribute("username", username);
//            request.setAttribute("email", email);
//            request.setAttribute("msg", "验证码错误");
//            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
//        }

    }


}
