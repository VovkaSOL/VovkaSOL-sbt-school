package com.sbt.javaschool.rnd.lesson13GOFno.facade.factory.builder;

public class CarBuilder extends Car {
    Car car= new Car();
    public CarBuilder createBody(){
        car.setBody("Корпус");
        return this;
      }
    public CarBuilder  createEngine(){
        car.setEngine("Двигатель");
        return this;
    }
    public  Car getCar(){
        return car;
    }
}
