package com.sbt.javaschool.rnd.lesson3publichouse;

import com.sbt.javaschool.rnd.lesson3publichouse.resworker.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("LOG посещений публичного дома");
        LogParser logParser= new LogParser("log.txt");


        logParser.toUnsortedSet();//уникальные слова

        System.out.println("Сортировка по длине");
        Comparator<String> comp = (String o1, String o2) -> (o1.length()-o2.length());
        logParser.toSortedSet(comp);//уникальные слова
        System.out.println("Сортировка по тексту в прямом порядке");
        Comparator<String> comp2 = (String o1, String o2) -> (o1.compareTo(o2));
        logParser.toSortedSet(comp2);//уникальные слова

        System.out.println("Сортировка с количеством повторов слова");
        logParser.toSortedMapWithCount();

        System.out.println("Тупой обратный порядок: ");
        logParser.toReverseArray();

        System.out.println("Обратный порядок с кастомным обратным итератором: ");
        logParser.toReverseArrayWithCustomIterator();//кто тут проститутка уже не поймешь :-)

        System.out.println("Вывод произвольных строк: ");
        logParser.PrintCustomStr(args);//задаются в аргументах в Run lesson 3

    }
}

