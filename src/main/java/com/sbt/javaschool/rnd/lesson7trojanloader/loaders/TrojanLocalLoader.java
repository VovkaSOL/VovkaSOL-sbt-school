package com.sbt.javaschool.rnd.lesson7trojanloader.loaders;
import com.sbt.javaschool.rnd.lesson7trojanloader.sms.SmsRuSender;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrojanLocalLoader implements AllLoadersInterface{
    List<String> fileNamesList;
    @Override
    public int loadAndRun(String path) {
     fileNamesList=new ArrayList<>();
        try {
            Files.walk(Paths.get(path))
                    .filter( p -> p.toString().endsWith(".java"))
                    .forEach(filePath -> fileNamesList.add(filePath.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fileNamesList.size()==0) return 0;
        for(String fname:fileNamesList){
            TrCompiler.compile(fname);
        }
        this.run();
       return 0;
    }
    @Override
    public void run() {
        for (String fname : fileNamesList) {
            URLClassLoader urlClassLoader = null;
            try {
                File dir = new File(fname).getParentFile();
                urlClassLoader = new URLClassLoader(new URL[]{dir.toURI().toURL()});
                Class<?> TrojanCl = urlClassLoader.loadClass("TrojanLocal");
                System.out.println("Из " + Arrays.asList(urlClassLoader.getURLs()).get(0).getPath() + " загрузили класс " + TrojanCl.getName() + "\n" + "Classloader name=" + urlClassLoader.toString());
                TrojanCl.getDeclaredMethod("run").invoke(TrojanCl.newInstance());
            } catch (Exception e) {
                System.out.println("Не удалось загрузить класс " + "TrojanOnServer" + " из класслоадера " + urlClassLoader.toString());
            }
        }

        SmsRuSender s = new SmsRuSender();
        s.InformAboutLoading("SBS_локальные_трояны_запущены");
    }
}
