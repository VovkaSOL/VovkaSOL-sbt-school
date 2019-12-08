package com.sbt.javaschool.rnd.lesson11threads.sсheduler;

import com.sbt.javaschool.rnd.lesson11threads.worker.Worker;

public class Sсheduler {
    // можем указать количество потоков для обработки списка файлов, можно указать
    //1 для последовательной однопоточной обработки
    public Sсheduler(int cntOfThreads, String[]  fileNames) {
        int fileIdx=0;
      while(fileIdx<fileNames.length){
        for(int thread=0;thread<cntOfThreads;thread++){
            if(fileIdx<fileNames.length){// проверяем чтобы не обратиться к несуществующему элементу массива fileNames
                Worker worker= new Worker(fileNames[fileIdx]);//запускаем поток обработки одного файла
                fileIdx++;
            }
        }
    }
    }
}
