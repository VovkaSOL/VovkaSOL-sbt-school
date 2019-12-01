package com.sbt.javaschool.rnd.lesson9lambda.nedostream;

import com.sbt.javaschool.rnd.lesson4generics.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NedoStream   {
    Integer[] i= new Integer[100];
    List<Object> lazyMethodsOfStream= new ArrayList<>();
    public NedoStream filter(Predicate<?> p){
        lazyMethodsOfStream.add(p);
        return this;
    }
    public void forEach(Consumer c){
        //c.accept();
    }
    public void doAllFunc(){
        //c.accept();
        for(int z=0; z < lazyMethodsOfStream.size(); z++){
            if(lazyMethodsOfStream.get(z) instanceof Predicate){
                ((Predicate)lazyMethodsOfStream.get(z)) .test(i[z]);
            }
        }
    }
}
