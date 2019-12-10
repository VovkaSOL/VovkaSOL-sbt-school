package com.sbt.javaschool.rnd.lesson12threadpool.scheduler;

import com.sbt.javaschool.rnd.lesson11threads.worker.Worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class Sсheduler {
    List<Future<Map>> workers=new ArrayList<>();
    Map<String,Integer> resultSetOfUnicalWordsInAllFiles = new HashMap<>(1000);
    // можем указать количество потоков для обработки списка файлов, можно указать
    //1 для последовательной однопоточной обработки
    public Sсheduler(int maxCntOfThreads, String[]  fileNames) {
        ExecutorService executorService = Executors.newFixedThreadPool(maxCntOfThreads);
        int fileIdx=0;
      while(fileIdx<fileNames.length){
          if(workers.size()!=0){//нужно дождаться освобождения потока если есть запущенные
             // waitUntilWorkersCompleteJob(maxCntOfThreads);
          }
        for(int thread=0;thread<maxCntOfThreads;thread++){
            if(fileIdx<fileNames.length){// проверяем чтобы не обратиться к несуществующему элементу массива fileNames
                Worker worker= new Worker(fileNames[fileIdx]);//запускаем поток обработки одного файла
                Future result = executorService.submit(worker);
                workers.add(result);
                fileIdx++;
            }
        }
      }

      for(int w=0;w<workers.size();w++){
          try {
              Map<String,Integer> resMap=workers.get(w).get();
              resMap.entrySet()
                      .forEach(entry -> resultSetOfUnicalWordsInAllFiles.merge(
                              entry.getKey(),
                              entry.getValue(),
                              (key, value) -> entry.getValue()   + value));
       ]   } catch (InterruptedException | ExecutionException e) {
              System.out.println("Поток был прерван, но у нас никакой логики в такой ситуации, просто пропускаем");
              e.printStackTrace();
          }
      }
      //System.out.println(resultSetOfUnicalWordsInAllFiles);
    }

}
