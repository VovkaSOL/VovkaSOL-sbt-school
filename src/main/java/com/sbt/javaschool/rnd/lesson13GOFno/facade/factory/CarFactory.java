package com.sbt.javaschool.rnd.lesson13GOFno.facade.factory;

import com.sbt.javaschool.rnd.lesson13GOFno.facade.factory.builder.Car;
import com.sbt.javaschool.rnd.lesson13GOFno.facade.factory.builder.CarBuilder;

public class CarFactory {
    public Car createCar(){
        return (new CarBuilder()).createBody().createEngine().getCar();
    }
}
