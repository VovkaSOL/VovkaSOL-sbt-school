package com.sbt.javaschool.rnd.lesson8serialization;

import com.sbt.javaschool.rnd.lesson8serialization.vk.Example;
import com.sbt.javaschool.rnd.lesson8serialization.vk.Item;
import com.sbt.javaschool.rnd.lesson8serialization.vk.Size;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {

        String filePath2 = System.getProperty("user.dir")
                            +System.getProperty("file.separator")
                            +"src"+System.getProperty("file.separator")
                             +"main"+System.getProperty("file.separator")
                             +"resources"+System.getProperty("file.separator")+
                             "SBS-L8ser"+System.getProperty("file.separator") +
                             "photos.json";//Путь где лежит база

        ObjectMapper mapper = new ObjectMapper();//инициализация библиотеки Jackson
        Example ex = (Example) mapper.readValue(new FileInputStream(filePath2), Example.class);
        for(Item item:ex.getResponse().getItems()){
                download(item,item.getId().toString());
        }
    }

    public static Item download(Item attachments,String dir)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(final Size attachment : attachments.getSizes()){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try{
                        String attUrl = attachment.getUrl();
                        String fileName = attachment.getType()+".jpg";
                        String destLoc = System.getProperty("user.dir")
                                        +System.getProperty("file.separator")
                                        +"src"+System.getProperty("file.separator")
                                        +"main"+System.getProperty("file.separator")
                                        +"resources"+System.getProperty("file.separator")
                                        +"SBS-L8ser"+System.getProperty("file.separator")
                                        +"loaded"+System.getProperty("file.separator")
                                        +dir+System.getProperty("file.separator");
                        URL url = new URL(attUrl);
                        File fileLocation = new File(destLoc, fileName);
                        FileUtils.copyURLToFile(url, fileLocation);
                        if(fileLocation.exists()) {
                            //attachment.setDownStatus("Completed");
                        }
                    }
                    catch(Exception e){
                        //attachment.setDownStatus("Failed");
                    }
                }
            });
        }
        executorService.shutdown();
        return attachments;
    }
}
