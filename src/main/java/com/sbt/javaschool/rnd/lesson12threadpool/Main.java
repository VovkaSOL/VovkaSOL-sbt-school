package com.sbt.javaschool.rnd.lesson12threadpool;

import com.sbt.javaschool.rnd.lesson11threads.sсheduler.Sсheduler;

public class Main {
    public static void main(String[] args) {
        int cntProcessors=Runtime.getRuntime().availableProcessors();
        System.out.println("Количество доступных ядер "+cntProcessors);
        //файлы берём из директории resources,
        //в папке лежат стихи Пушкина
        //на выходе получаем HashMap с количеством повторений слов
        for(int i=0;i<100;i++){
            startScheduler(5);
        }

        long minTime=100000000000000L;
        int bestCntThreads=0;
        for(int i=1;i<10;i++) {
            long start = System.nanoTime();
            startScheduler(i);
            long time = (System.nanoTime() - start);
            System.out.println("При "+i+" потоках время выполнения "+time/1_000_000+" мсек");
            if (time < minTime) {
                minTime = time;
                bestCntThreads = i;
            }
        }

        System.out.println("При таких входных данных, оптимальнее всего использовать "+bestCntThreads+" потоков");
    }

    private static void startScheduler(int cntThreads){
        Sсheduler scheduler=new Sсheduler(cntThreads, new String[]{
                "SBS-L11threads/file1.txt",
                "SBS-L11threads/file2.txt",
                "SBS-L11threads/file3.txt",
                "SBS-L11threads/file4.txt",
                "SBS-L11threads/file5.txt"});
    }

}
