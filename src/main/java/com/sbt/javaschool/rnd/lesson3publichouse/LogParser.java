package com.sbt.javaschool.rnd.lesson3publichouse;

import com.sbt.javaschool.rnd.lesson3publichouse.resworker.ResourceLoader;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser {
    List<String> allwords = new ArrayList<>();

    LogParser(String file) {
        //такой оверхед только для поработать со стримами
        InputStream logInputStream = new ResourceLoader(file).getAsStream();
        allwords=ConvertStreamToList(logInputStream);
    }
    public void toUnsortedSet(){
        Set <String> s=new HashSet<>(allwords);
        System.out.println(s);
    }
    public void toSortedSet(){
        Set <String> s=new TreeSet<>(allwords) ;
        System.out.println(s);
    }
    public void toSortedSet(Comparator comp){
        //Comparator<String> comp = (String o1, String o2) -> (o1.compareTo(o2));
        Set <String> s=new TreeSet<>(comp);//allwords);
        s.addAll(allwords);
        System.out.println(s);
    }
    public void toSortedMap(Comparator comp){
        //Comparator<String> comp = (String o1, String o2) -> (o1.compareTo(o2));
        Set <String,> s=new TreeMap<>(comp);
        s.addAll(allwords);
        System.out.println(s);
    }


    private List<String> ConvertStreamToList(InputStream is) {
        List<String> tempArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF8"))) {
            String read = null;
            while ((read = br.readLine()) != null) {
                String[] splited = read.split(" ");
                for (String part : splited) {
                    if (!part.matches(".*\\d.*")) {//если в строке нет цифр
                        tempArrayList.add(part);
                    }
                }
            }
            //System.out.println("Различные имена:"+diffset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempArrayList;
    }



}