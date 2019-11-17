package com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part1reflection;

import java.lang.reflect.Method;

//попробуем самурайский TDD, пишем сначала объявление метода так, чтобы его можно было затестить в Unit тестах,
//потом пишем тест, только потом реализацию самого метода
//пробуем писать методы так, чтобы самому не писать тесты а их генерировал плагин Squaretest или Testme:-)
public class ReflectionRecursiveMethodGetter {
    static String getRecursiveMethods(String classname){
        StringBuilder methods=new StringBuilder();
        // до этой строки написано перед генерацией теста
        // потом сгенерирован тест, получилось хорошо, пишем реализацию дальше
        Class <?> cl;
        try {
            cl= Class.forName(classname);
        } catch (ClassNotFoundException e) {
            return methods.toString();// если нет такого класса, возвращаем пустой лист
        }
        while(cl!=null) {
            Method[] m=cl.getDeclaredMethods();
            for(int i=0;i<m.length;i++) {
                methods.append(m[i].toString());
            }
            cl=cl.getSuperclass();
        }
        return methods.toString();
    }
}
