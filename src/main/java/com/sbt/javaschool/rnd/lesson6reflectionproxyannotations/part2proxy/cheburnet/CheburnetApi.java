package com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy.cheburnet;

import com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy.annotations.Cache;

public interface CheburnetApi {
    @Cache
    public String searchInCheburnet(String text);
}
