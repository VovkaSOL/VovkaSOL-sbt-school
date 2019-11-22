package com.sbt.javaschool.rnd.lesson7trojanloader.loaders;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TrCompiler {
    static void compile(String javaSrc){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);

        File src= new File(javaSrc);
        File parentDirectory = src.getParentFile();
        //File parentDirectory=new File("C\1");
        try {
            manager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(parentDirectory));
            Iterable<? extends JavaFileObject> compilationUnits = manager.getJavaFileObjectsFromFiles(Arrays.asList(src));
            compiler.getTask(null, manager, null, null, null, compilationUnits).call();
            manager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Сгенерирован класс " + src.getAbsolutePath());
    }
}
