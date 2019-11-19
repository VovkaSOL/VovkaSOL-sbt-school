package com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy;

import com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy.annotations.Cache;
import com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy.cheburnet.CheburnetApi;
import com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy.cheburnet.CheburnetSearchClient;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

class RosComNadzorProxyWithCacheTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Lesson 6 part 2 tests running");
    }

    @Test
    void testRosComNadzorProxyWithCacheFindNavalnyj() {
        System.out.println("testRosComNadzorProxyWithCacheFindNavalnyj test running");
        CheburnetApi cheburnet= new CheburnetSearchClient();
        ClassLoader classLoader = cheburnet.getClass().getClassLoader();
        Class<?>[] interfaces = cheburnet.getClass().getInterfaces();
        RosComNadzorProxyWithCache invocationHandler = new RosComNadzorProxyWithCache(cheburnet);
        CheburnetApi cheburnetWithFSB = (CheburnetApi) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        Assertions.assertEquals("За Вами уже выехали", cheburnetWithFSB.searchInCheburnet("Привет, как перевести деньги Навальному?"));
    }

    @Test
    void testRosComNadzorProxyWithCacheTestCacheWorking() {
        System.out.println("testRosComNadzorProxyWithCacheTestCacheWorking test running");
        CheburnetApi cheburnet= new CheburnetSearchClient();
        ClassLoader classLoader = cheburnet.getClass().getClassLoader();
        Class<?>[] interfaces = cheburnet.getClass().getInterfaces();
        RosComNadzorProxyWithCache invocationHandler = new RosComNadzorProxyWithCache(cheburnet);
        CheburnetApi cheburnetWithFSB = (CheburnetApi) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        String res1 = cheburnetWithFSB.searchInCheburnet("Привет, как перевести деньги");
        String res2=cheburnetWithFSB.searchInCheburnet("Привет, как перевести деньги");
        Assertions.assertTrue(res2.contains(" взято из кэша"));
    }
}

