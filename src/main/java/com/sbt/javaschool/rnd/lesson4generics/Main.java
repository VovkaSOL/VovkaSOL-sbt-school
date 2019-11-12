package com.sbt.javaschool.rnd.lesson4generics;

import com.sbt.javaschool.rnd.lesson4generics.countmap.CountMap;
import com.sbt.javaschool.rnd.lesson4generics.countmap.UserMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s1="Первый объект";
        String s2="Второй объект";
        CountMap<String> m=new UserMap<>();
        m.add(s1);
        m.add(s1);
        m.add(s1);
        m.add(s2);
        m.add(s2);
        System.out.println(m);
        int count = m.getCount("Первый объект"); // 2
        //int count2 = m.getCount(12); // ругаецца на int как и должен
        System.out.println("count="+count);
        System.out.println(m.toMap());
        Map z= new HashMap();
        m.toMap(z);
        System.out.println("z="+z);
    }
}
