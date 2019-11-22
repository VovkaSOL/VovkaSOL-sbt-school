package com.sbt.javaschool.rnd.lesson7trojanloader.loaders;

public interface TrojanLoderInformer {
    //интерфейс, описывающий поведение всех оповещателей загрузки плагинов
    // (смс, запись в лог ....)
    void InformAboutLoading(String text);
}