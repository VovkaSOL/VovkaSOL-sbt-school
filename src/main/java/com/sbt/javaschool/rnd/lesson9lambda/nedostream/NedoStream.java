package com.sbt.javaschool.rnd.lesson9lambda.nedostream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NedoStream<T> {
    Collection<T> streamValues;//ссылка на коллекцию с которой работает стрим
    List<Object> lazyMethodsOfStream;//набор ленивых функций для дальнейшего прохождения по пайплайну

    public NedoStream(Collection<T> collection, List<Object> lazyMethodsOfStream) {
        this.streamValues = collection;
        this.lazyMethodsOfStream = lazyMethodsOfStream;
    }

    public NedoStream<T> filter(Predicate<? super T> p) {
        lazyMethodsOfStream.add(p);
        return this;
    }


    //map меняет тип данных в коллекции
    public <R> NedoStream<R> map(Function<T, R> f) {
        lazyMethodsOfStream.add(f);
        //возвращаем стрим, типизированный типом возврата в Function ->R
        NedoStream<R> s = new NedoStream(this.streamValues, this.lazyMethodsOfStream);
        return s;
    }

    public static <T> NedoStream<T> of(Collection<T> c) {
        NedoStream<T> s = new NedoStream<>(c, new ArrayList<>());
        return s;
    }

    public <R> void forEach(Consumer<R> consumer) {
        Iterator methodIterator=lazyMethodsOfStream.iterator();
        while( methodIterator.hasNext()) {
            Object m=methodIterator.next();
            if (m instanceof Predicate) {//filter
                Iterator iterator = streamValues.iterator();
                while( iterator.hasNext()) {
                    if (((Predicate) m).test(iterator.next()) == false) {
                        iterator.remove();
                    }
                }
                methodIterator.remove();
                continue;
            }
            if (m instanceof Function) {//map
                List<R> arr = new ArrayList<>();
                for (Iterator iterator = streamValues.iterator(); iterator.hasNext(); ) {
                    arr.add((R) ((Function) m).apply(iterator.next()));
                }
                methodIterator.remove();
                NedoStream<R> s = new NedoStream<>(arr, this.lazyMethodsOfStream);
                s.forEach(consumer);
                return;
            }
        }
        for (Iterator iterator = streamValues.iterator(); iterator.hasNext(); ) {
            consumer.accept((R) iterator.next());
        }
    }
}
