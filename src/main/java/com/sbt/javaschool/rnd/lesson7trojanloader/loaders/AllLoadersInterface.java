package com.sbt.javaschool.rnd.lesson7trojanloader.loaders;

import com.sbt.javaschool.rnd.lesson7trojanloader.sms.SmsRuSender;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public interface AllLoadersInterface {
    int loadAndRun(String path);
    void run();
}
