package com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part1reflection;

public class Main {
    public static void main(String[] args) {
        String result = ReflectionRecursiveMethodGetter.getRecursiveMethods("com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part1reflection.ReflectionRecursiveMethodGetter");
        System.out.println(result);
    }
}
