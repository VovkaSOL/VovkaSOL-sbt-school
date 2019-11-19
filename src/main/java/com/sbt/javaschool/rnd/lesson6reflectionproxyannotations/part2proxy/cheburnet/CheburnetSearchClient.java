package com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy.cheburnet;

import com.sbt.javaschool.rnd.lesson6reflectionproxyannotations.part2proxy.annotations.Cache;

public class CheburnetSearchClient implements CheburnetApi {

    @Override
    public String searchInCheburnet(String text) {
      return "Cheburnet is coming soon...";
    }
}
