package com.sbt.javaschool.rnd.lesson13GOFno.facade.factory.builder;

public class Car {
    String engine="Дв";
    String body="Ко";

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
