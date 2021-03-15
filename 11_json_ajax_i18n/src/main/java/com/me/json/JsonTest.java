package com.me.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.me.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

    // javaBean和json的转换
    @Test
    public void test1() {
        Person person = new Person(1, "java");
        // 创建json对象实例
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);

        Person personFromJson = gson.fromJson(personJsonString, Person.class);
        System.out.println(personFromJson);
    }

    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(1, "国哥"));
        personList.add(new Person(2, "康师傅"));

        Gson gson = new Gson();
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);
        List<Person> list = gson.fromJson(personListJsonString, new PersonListType().getType());
        System.out.println(list);
    }

    @Test
    public void test3() {
        Map<Integer, Person> PersonMap = new HashMap<>();
        PersonMap.put(1, new Person(1, "国哥"));
        PersonMap.put(2, new Person(1, "康师傅"));

        Gson gson = new Gson();
        String personMapJsonString = gson.toJson(PersonMap);
        System.out.println(personMapJsonString);
//        Object personMapFromJson = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        Object personMapFromJson = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer, Person>>(){}.getType());
        System.out.println(personMapFromJson);
    }
}
