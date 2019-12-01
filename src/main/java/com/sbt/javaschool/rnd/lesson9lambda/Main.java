package com.sbt.javaschool.rnd.lesson9lambda;

import com.sbt.javaschool.rnd.lesson9lambda.nedostream.NedoStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        long start=System.nanoTime();
        List<Integer> l=new ArrayList<>(1000000);
        Stream<Integer> s = Stream.iterate(0, i -> i + 1);
        l=s.limit(1000000).map(i->i*2).collect(Collectors.toList());

        long stop=System.nanoTime();
        System.out.println("Время выполнения = "+(stop-start)/1000000+" мсек");//мсек


        NedoStream myS=new NedoStream();
        myS.filter(x-> true)
                .filter(x-> true)
                .filter(x-> false);

    }
}
