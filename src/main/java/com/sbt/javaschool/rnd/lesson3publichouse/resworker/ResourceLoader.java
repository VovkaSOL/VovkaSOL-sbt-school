package com.sbt.javaschool.rnd.lesson3publichouse.resworker;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class ResourceLoader {

    InputStream inputStream;
    public ResourceLoader(String fileName){
        inputStream=getFileFromResources(fileName);
    }

    private InputStream getFileFromResources(String fileName) {
        InputStream is = getClass()
                .getClassLoader().getResourceAsStream(fileName);
        return is;
    }

    public InputStream getAsStream() {
        return inputStream;
    }
}
