package com.sbt.javaschool.rnd.lesson11threads.worker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class Worker implements Runnable {
    private String workFileName;
    private Thread thread;

    public Map<String,Integer> getResults() {
        return results;
    }

    private Map<String,Integer> results = new HashMap<>();
    public Worker(String fileName) {
        workFileName=fileName;
        thread = new Thread(this, "ThreadWithFile="+workFileName);
        thread.start();
    }
    public void join() throws InterruptedException {
        thread.join();
    }
    public boolean isAlive() {
        return thread.isAlive();
    }

    @Override
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
}
