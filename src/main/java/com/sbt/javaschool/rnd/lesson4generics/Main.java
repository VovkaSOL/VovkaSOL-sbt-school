package com.sbt.javaschool.rnd.lesson4generics;

import com.sbt.javaschool.rnd.lesson4generics.countmap.CountMap;
import com.sbt.javaschool.rnd.lesson4generics.countmap.UserMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.*;

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


        //part2 test
        List<Integer> l2=CollectionUtils.range(Arrays.asList(1,2,3,4,6,7,8),3,6);
        System.out.println(l2);//гуд

        Comparator<String> testComparator = new Comparator <String>() {

            @Override
            public int compare(String e1, String e2) {
                return (int) (e1.compareTo(e2));
            }
        };
        List<String> l3=CollectionUtils.range(Arrays.asList("1","22","223","333","4444"),"22","333",testComparator);

        System.out.println(l3);//гуд
    }

    @Test
    public void TestFunc() {
        //тесты нужно добавить позже
        System.out.println("Tests run");
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


        //part2 test
        List<Integer> l2=CollectionUtils.range(Arrays.asList(1,2,3,4,6,7,8),3,6);
        System.out.println(l2);//гуд

        Comparator<String> testComparator = new Comparator <String>() {

            @Override
            public int compare(String e1, String e2) {
                return (int) (e1.compareTo(e2));
            }
        };
        List<String> l3=CollectionUtils.range(Arrays.asList("1","22","223","333","4444"),"22","333",testComparator);

        System.out.println(l3);//гуд
    }
}
