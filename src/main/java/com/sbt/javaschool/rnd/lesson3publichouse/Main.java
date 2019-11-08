package com.sbt.javaschool.rnd.lesson3publichouse;

import com.sbt.javaschool.rnd.lesson3publichouse.resworker.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("LOG посещений публичного дома");
        LogParser logParser= new LogParser("log.txt");
        //logParser.toUnsortedSet();
        //logParser.toSortedSet();
        Comparator<String> comp = (String o1, String o2) -> (o1.length()-o2.length());
        logParser.toSortedSet(comp);
    }
}

