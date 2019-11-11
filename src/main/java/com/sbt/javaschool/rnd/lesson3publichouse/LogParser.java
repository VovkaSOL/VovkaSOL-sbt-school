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
        System.out.println("Unsorted set:"+s);
    }
    public void toSortedSet(){
        Set <String> s=new TreeSet<>(allwords) ;
        System.out.println("Sorted set without comparator::"+s);
    }
    public void toSortedSet(Comparator comp){
        //Comparator<String> comp = (String o1, String o2) -> (o1.compareTo(o2));
        Set <String> s=new TreeSet<>(comp);//allwords);
        s.addAll(allwords);
        System.out.println("Sorted set with comparator:"+s);
    }

    public void toSortedMapWithCount(){
        System.out.print("Map with cnt: " );
        Map <String,Integer> m=new HashMap<>();
        //раскладываем в МАП
        for(int counter=0; counter <= allwords.size() - 1; counter++) {
            String tmpKey=allwords.get(counter);
            if(m.containsKey(tmpKey)){
                m.put(tmpKey, (Integer)m.get(tmpKey)+1);
            }
            else m.put(tmpKey, 1);
        }
        System.out.println(m.entrySet());
    }

    public void toReverseArray(){
        System.out.print("Simple reverse array: " );
        for(int counter=allwords.size() - 1; counter > 0; counter--) {
            System.out.print(" "+allwords.get(counter));
        }
        System.out.println(" ");
    }

    public void toReverseArrayWithCustomIterator(){
        Iterator <String> it = new Iterator <String>() {
            private int currentIndex = allwords.size()-1;

            @Override
            public boolean hasNext() {
                return currentIndex >0 && allwords.get(currentIndex) != null;
            }

            @Override
            public String next() {
                return allwords.get(currentIndex--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        System.out.print("Custom iterator reverse array: " );
        while (it.hasNext())
            System.out.print(" "+it.next());
        System.out.println(" ");
    }

    public void PrintCustomStr(String[] args){
        System.out.println("Custom string from args: " );
        for(String s : args){
            //System.out.println(s);
            System.out.println(s+"="+allwords.get(new Integer(s)));
        }
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