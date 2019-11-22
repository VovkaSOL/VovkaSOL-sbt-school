package com.sbt.javaschool.rnd.lesson7trojanloader.loaders;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TrojanFromRemoteServerLoader implements AllLoadersInterface {

    @Override
    public int load(String serverURL) {
        return loadJavaFileFromServer(serverURL);
    }

    int loadJavaFileFromServer(String serverURL) {
            URL yahoo = null;
            try {
                yahoo = new URL(serverURL);
                URLConnection yc = yahoo.openConnection();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(yc.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine);
                in.close();
            }
            catch (Exception e) {
                System.out.println("Чёй то не получилось отправить смс, ну а что делать, продолжаем работать");
            }
        return 1;
    }
}
