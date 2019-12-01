package test.java.com.sbt.javaschool.rnd.lesson9lambda;

import com.sbt.javaschool.rnd.lesson9lambda.nedostream.NedoStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class NedoStreamTest {

    @Test
    void NedoStreamTestSpeedTest() {
        System.out.println("NedoStreamTestSpeedTest замер производительности");
        List<Integer> list = IntStream.rangeClosed(0, 100000)
                .boxed().collect(Collectors.toList());
        long start=System.nanoTime();
        NedoStream.of(list)
                .filter(x->x>5)
                .filter(x->x<6)
                .map(x->x.toString())
                .forEach(System.out::println);
        long stop=System.nanoTime();
        long timeMs=(stop-start)/1000000;
        System.out.println("Время выполнения NedoStream = "+timeMs+" мсек");//мсек
        Assertions.assertTrue(timeMs>500, "Ваш стрим слишком быстрый, Вован не мог такое написать :-)");

    }
}