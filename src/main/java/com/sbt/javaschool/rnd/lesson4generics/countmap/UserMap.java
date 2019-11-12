package com.sbt.javaschool.rnd.lesson4generics.countmap;

import java.util.HashMap;
import java.util.Map;

//без generics <T> я не смог подружить
//параметризованный public V remove(Object key) из HashMap
//и raw метод int remove(Object o) из интерфейса CountMap
//add параметризованный тоже не смог подружить :-) public V remove(Object key) и int removeItem(T o);
// пришлось переименовать в removeItem в интерфейсе;
public class UserMap <T> extends HashMap <T,Integer> implements CountMap<T>{

    //я не уверен что нативная реализация hashCode у Object всегда возвращает одно и то же число
    //но на моей машине прокатывает, хэши не меняются, в следующий раз придумаю что нибудь получше :-)

    @Override
    public void add(T o) {
        if(super.containsKey(o)){
            super.put(o, (Integer)super.get(o)+1);
        }
        else super.put(o, 1);
    }

    @Override
    public int getCount(T o) {
        Integer i= new Integer(super.get(o));
        if(i==null) i=0;
        return i;
    }

    public int removeItem(T o) {
        int r=0;
        if(super.containsKey(o)) {
            r=super.get(o);
            super.remove(o);
        }
        return r;
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void addAll(CountMap source) {
        super.putAll(source.toMap());
    }

    @Override
    public Map toMap() {
        HashMap m= new HashMap(this);

        return m;
    }

    @Override
    public void toMap(Map destination) {
        destination.putAll(this.toMap());
    }
}
