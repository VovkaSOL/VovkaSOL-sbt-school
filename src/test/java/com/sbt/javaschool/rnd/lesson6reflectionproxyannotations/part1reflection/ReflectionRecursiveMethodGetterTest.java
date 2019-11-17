package com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part1reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReflectionRecursiveMethodGetterTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Lesson 6 part 1 tests running");
    }

    @Test
    void testGetRecursiveMethods() {
        System.out.println("Тест рекурсивного получения всех методов класса до Object");
        String result = ReflectionRecursiveMethodGetter.getRecursiveMethods("com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part1reflection.ReflectionRecursiveMethodGetter");
        String goodres = "static java.lang.String com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part1reflection.ReflectionRecursiveMethodGetter.getRecursiveMethods(java.lang.String)protected void java.lang.Object.finalize() throws java.lang.Throwablepublic final void java.lang.Object.wait() throws java.lang.InterruptedExceptionpublic final void java.lang.Object.wait(long,int) throws java.lang.InterruptedExceptionpublic final native void java.lang.Object.wait(long) throws java.lang.InterruptedExceptionpublic boolean java.lang.Object.equals(java.lang.Object)public java.lang.String java.lang.Object.toString()public native int java.lang.Object.hashCode()public final native java.lang.Class java.lang.Object.getClass()protected native java.lang.Object java.lang.Object.clone() throws java.lang.CloneNotSupportedExceptionpublic final native void java.lang.Object.notify()public final native void java.lang.Object.notifyAll()private static native void java.lang.Object.registerNatives()";
        Assertions.assertEquals(goodres, result);
        goodres = "фуфло";
        Assertions.assertNotEquals(goodres, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme