package com.sbt.javaschool.rnd.lesson9lambda.nedostream;

import com.sbt.javaschool.rnd.lesson4generics.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NedoStream<T>  {
    public List<T> streamValues= new ArrayList<>();
    List<Object> lazyMethodsOfStream= new ArrayList<>();
    public NedoStream<T> filter(Predicate<? super T> p){
        lazyMethodsOfStream.add(p);
        return this;
    }

    public NedoStream<T> map(Function<T,?> f){
        lazyMethodsOfStream.add(f);
        return this;
    }

    public static <T> NedoStream<T>  of(Collection <T> c){
        NedoStream<T>  s=new NedoStream<>();
        s.streamValues.addAll(c);
        return s;
    }
    public <R> void forEach(Consumer<T> c){
        lazyMethodsOfStream.add(c);
        for(int m=0; m < lazyMethodsOfStream.size(); m++){
            if(lazyMethodsOfStream.get(m) instanceof Predicate) {//filter
                for(int i=0;i<streamValues.size();i++) {
                    if(((Predicate) lazyMethodsOfStream.get(m)).test(streamValues.get(i))==false){
                        streamValues.remove(i);
                    }
                }
            }
            if(lazyMethodsOfStream.get(m) instanceof Function){//map
                List<R> arr=new ArrayList<>();
                for(int i=0;i<streamValues.size();i++) {
                    arr.add((R)((Function) lazyMethodsOfStream.get(m)).apply(streamValues.get(i)));
                }
                List<R>streamValues=new ArrayList<>(arr);
            }
            if(lazyMethodsOfStream.get(m) instanceof Consumer){//forEach
                List<R> arr=new ArrayList<>();
                for(int i=0;i<streamValues.size();i++) {
                    ((Consumer) lazyMethodsOfStream.get(m)).accept(streamValues.get(i));
                }
                List<R>streamValues=new ArrayList<>(arr);
            }
        }
    }
 }
