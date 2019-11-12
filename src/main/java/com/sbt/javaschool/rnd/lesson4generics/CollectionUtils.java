package com.sbt.javaschool.rnd.lesson4generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    // понял что сделать с этой функцией
    public static List newArrayList() {
    }

    public static <T> indexOf(List source, Object o) {
//        Iterator <T> it=source.iterator();
//        while (it.hasNext()) {
//            T tmp=it.next();
//            if (tmp.equals(o)){
//                return it.;
//            }
//        }
    }

    public static List limit(List source, int size) {
    }

    public static <T> void add(List <? super T>source, T o) {
       source.add(o);
    }

    public static <T> void removeAll(List <? super T> removeFrom, List <? extends T> c2) {

    }

    public static <T> boolean containsAll(List <? extends T>c1, List<? extends T> c2) {
          return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List <? extends T>c1, List <? extends T>c2) {
        for(T o:c2) {
           if (c1.contains(o)) return true;
        }
        return false;
    }

    public static <T> List<T> range(List <? extends Comparable>list, Comparable min, Comparable max) {
       List<T> ls= new ArrayList<T>();
       for(Comparable o:list){
           if(o.compareTo(min))
       }
    }

    public static List range(List list, Object min, Object max, Comparator comparator) {
    }

}

