package com.sbt.javaschool.rnd.training.spring.test1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
/*
public class Downloader extends Thread {
    String URLlink;
    String PathToSave;
    void setLinkAndPath(String link,String path){
        URLlink=link;
        PathToSave=path;
    }
    public void run() {
        try {
            FileUtils.copyURLToFile(new URL(URLlink), new File(PathToSave));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Program
{
    static Downloader mSecondThread;

    public static void main(String[] args)
    {
        ArrayList arr= new ArrayList();//массив ссылок
        for(int i=0;i<arr.size();i++) {
            mThread = new Downloader();    //Создание потока
            //путь можно брать из массива arr.get(i);
            mThread.setLinkAndPath(//Путь откуда качать, Путь куда качать);
            mThread.start();                    //Запуск потока
        }
        System.out.println("Главный поток завершён...");
    }
}
*/