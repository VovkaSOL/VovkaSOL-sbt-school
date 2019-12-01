package com.sbt.javaschool.rnd.lesson9lambda;

import com.sbt.javaschool.rnd.lesson9lambda.nedostream.NedoStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        List<Integer> list = IntStream.rangeClosed(0, 100000)
                .boxed().collect(Collectors.toList());


        long start=System.nanoTime();
                list.stream().filter(x->x>5)
                .filter(x->x<6)
                .map(x->x.toString())
                .forEach(x->System.out.println(x));
        long stop=System.nanoTime();
        System.out.println("Время выполнения Stream = "+(stop-start)/1000000+" мсек");//мсек

        start=System.nanoTime();
        NedoStream.of(list)
                .filter(x->x>5)
                .filter(x->x<6)
                .map(x->x.toString())
                .forEach(System.out::println);
        stop=System.nanoTime();
        System.out.println("Время выполнения NedoStream = "+(stop-start)/1000000+" мсек");//мсек
    }
}
