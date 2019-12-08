package com.sbt.javaschool.rnd.lesson11threads.worker;

import java.io.InputStream;
import java.net.URL;

public class Worker implements Runnable {
    private String workFileName;
    private Thread thread;
    public Worker(String fileName) {
        workFileName=fileName;
        thread = new Thread(this, "ThreadWithFile="+workFileName);
        thread.start();
    }
    @Override
    public void run() {
        URL url=getClass().getClassLoader().getResource(workFileName);
    }
}
