package com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy;



import com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy.annotations.Cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class RosComNadzorProxyWithCache implements InvocationHandler {
    private final Object delegate;
    Map<String,String> localCache=new TreeMap<>();
    //Comparator<String> comp = (String o1, String o2) -> (o1.compareTo(o2));
    //Set<String> localCache=new TreeSet<>(comp);//allwords);

    public RosComNadzorProxyWithCache(Object whatsapp) {
        this.delegate=whatsapp;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("searchInCheburnet")==false) {
            //нам нужен только методы searchInCheburnet, поэтому остальные просто прокидываем
            Object res=method.invoke(delegate, args);
            return res;
        }
        // дальше работаем только с searchInCheburnet
        if(args.length==0) return "error";
        String ar=(String)args[0];
        if(ar.contains("Навальн")){
            return "За Вами уже выехали";
        }

        if (method.isAnnotationPresent(Cache.class)){
            //метод имеет аннотацию Cache
            String cacheRet=findResInLocalCache(ar);
            if(cacheRet!=null) return (cacheRet+" взято из кэша");
        }

        Object res=method.invoke(delegate, args);
        if (method.isAnnotationPresent(Cache.class)) localCache.put(ar, (String)res);
        return res;
    }

    String findResInLocalCache(String req){
        if(localCache.containsKey(req)){
            return localCache.get(req);
        }
        else return null;
    }

}
