package com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy;

import com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy.cheburnet.CheburnetApi;
import com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy.cheburnet.CheburnetSearchClient;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        CheburnetSearchClient cheburnet= new CheburnetSearchClient();
        ClassLoader classLoader = cheburnet.getClass().getClassLoader();
        Class<?>[] interfaces = cheburnet.getClass().getInterfaces();
        RosComNadzorProxyWithCache invocationHandler = new RosComNadzorProxyWithCache(cheburnet);
        CheburnetApi cheburnetWithFSB = (CheburnetApi)Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        String res=cheburnetWithFSB.searchInCheburnet("Привет, как перевести деньги Навальному?");
        System.out.println(res);
        res=cheburnetWithFSB.searchInCheburnet("Привет, как перевести деньги");
        System.out.println(res);
        //второй вызов будет из кэша
        res=cheburnetWithFSB.searchInCheburnet("Привет, как перевести деньги");
        System.out.println(res);
    }
}
