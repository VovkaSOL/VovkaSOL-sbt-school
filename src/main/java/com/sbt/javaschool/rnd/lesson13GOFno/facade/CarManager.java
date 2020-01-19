package com.sbt.javaschool.rnd.lesson13GOFno.facade;

import com.sbt.javaschool.rnd.lesson13GOFno.facade.factory.CarFactory;
import com.sbt.javaschool.rnd.lesson13GOFno.facade.factory.builder.Car;

public class CarManager {
    public Car newOrder(String whatClientWhant){
        if(whatClientWhant.contains("машин")){
            return (new CarFactory()).createCar();
        }
        return null;
    }
}
