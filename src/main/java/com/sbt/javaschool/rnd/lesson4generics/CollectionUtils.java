package com.sbt.javaschool.rnd.lesson4generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

//    public static <T> indexOf(List source, Object o) {
////        Iterator <T> it=source.iterator();
////        while (it.hasNext()) {
////            T tmp=it.next();
////            if (tmp.equals(o)){
////                return it.;
////            }
////        }
//    }

    public static List limit(List source, int size) {
        return null;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T o : c2) {
            if (c1.contains(o)) return true;
        }
        return false;
    }

    //не сразу получилось но получилось :-)
    public static <T extends Comparable> List<T> range(List<T> list, T min, T max) {
        List<T> ls = new ArrayList<T>();
        for (T o : list) {
            if (o.compareTo(min) >= 0 && o.compareTo(max) <= 0) {
                ls.add(o);
            }
        }
        return ls;
    }

    public static <T extends Comparable> List<T> range(List<T> list, T min, T max, Comparator comp) {
        List<T> ls = new ArrayList<T>();
        for (T o : list) {
            if (comp.compare(o, min) >= 0 && comp.compare(o, max) <= 0) {
                ls.add(o);
            }
        }
        return ls;
    }

}

