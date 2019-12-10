package com.sbt.javaschool.rnd.lesson12threadpool.worker;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Worker  implements Callable<Map<String,Integer>> {
    private String workFileName;
    private Thread thread;

    private Map<String,Integer> results = new HashMap<>();
    public Worker(String fileName) {
        workFileName=fileName;
    }

    public void run() {
        readFileAndPutWordsToSet();
    }
    void readFileAndPutWordsToSet(){
        URL url=getClass().getClassLoader().getResource(workFileName);
        //System.out.println(url);
        File f=new File(url.getPath());
        Scanner in = null;
        try {
            in = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(in.hasNextLine()){
            String currentLine = in.nextLine();
            String[] words = currentLine.split(" ");     // the delimiter inside the quotes
            for(String w : words){
                String newW=w.replaceAll("[:,.-;]","").toLowerCase();
                if(results.containsKey(newW)){
                    results.put(newW,results.get(newW)+1);
                }
                else results.put(newW,1);
            }
        }
    }

    @Override
    public Map<String,Integer> call() throws Exception {
        readFileAndPutWordsToSet();
        return results;
    }
}
