package com.sbt.javaschool.rnd.lesson14gc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //-XX:+PrintCompilation
        //-XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
        //-XX:+UseSerialGC
        //-XX:+UseParallelGC
        //-XX:+UseConcMarkSweepGC
        //-XX:+UseG1GC
        Map<Integer, String> testMap = new HashMap<>();
        List<String> testList=new ArrayList<>();
        boolean alwaysTrue=true;
        long z=0;
        while (alwaysTrue) {
            try {
                testMap.put(3, "value " + 3);
                testList.add("Hi"+System.nanoTime());
            } catch (OutOfMemoryError e) {
                testMap.clear();
                testList.clear();
                System.out.println("reset");
            }

        }
        for(int i=0;i<1000000;i++)
        {
            System.out.println(testList.get(i));
        }
    }
}
