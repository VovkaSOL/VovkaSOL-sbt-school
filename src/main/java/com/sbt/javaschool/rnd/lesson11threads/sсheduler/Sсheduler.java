package com.sbt.javaschool.rnd.lesson11threads.sсheduler;

import com.sbt.javaschool.rnd.lesson11threads.worker.Worker;

import java.sql.SQLOutput;
import java.util.*;

import static java.lang.Thread.sleep;

public class Sсheduler {
    List<Worker> workers=new ArrayList<>();
    Map<String,Integer> resultSetOfUnicalWordsInAllFiles = new HashMap<>(1000);
    // можем указать количество потоков для обработки списка файлов, можно указать
    //1 для последовательной однопоточной обработки
    public Sсheduler(int maxCntOfThreads, String[]  fileNames) {
        int fileIdx=0;
      while(fileIdx<fileNames.length){
          if(workers.size()!=0){//нужно дождаться освобождения потока если есть запущенные
              waitUntilWorkersCompleteJob(maxCntOfThreads);
          }
        for(int thread=0;thread<maxCntOfThreads;thread++){
            if(fileIdx<fileNames.length){// проверяем чтобы не обратиться к несуществующему элементу массива fileNames
                Worker worker= new Worker(fileNames[fileIdx]);//запускаем поток обработки одного файла
                workers.add(worker);
                fileIdx++;
            }
        }
      }
      //дожидаемся завершения всех workers
      for(int w=0;w<workers.size();w++){
          try {
              workers.get(w).join();
              Map<String,Integer> resMap=workers.get(w).getResults();
              resMap.entrySet()
                      .forEach(entry -> resultSetOfUnicalWordsInAllFiles.merge(
                              entry.getKey(),
                              entry.getValue(),
                              (key, value) -> entry.getValue()   + value));
              //resultSetOfUnicalWordsInAllFiles.addAll(workers.get(w).getResults());
          } catch (InterruptedException e) {
              System.out.println("Поток был прерван, но у нас никакой логики в такой ситуации, просто пропускаем");
              e.printStackTrace();
          }
      }
      //System.out.println(resultSetOfUnicalWordsInAllFiles);
    }
  void waitUntilWorkersCompleteJob(int cntRunnedThreads) {
      int cntRunned = 1000;
      while (cntRunned >= cntRunnedThreads) {
          cntRunned = 0;
          for (Worker w : workers) {
              if (w.isAlive()) cntRunned++;
          }
          try {
              sleep(1);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
}
