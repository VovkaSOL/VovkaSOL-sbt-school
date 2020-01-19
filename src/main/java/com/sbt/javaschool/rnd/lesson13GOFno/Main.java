package com.sbt.javaschool.rnd.lesson13GOFno;

import com.sbt.javaschool.rnd.lesson13GOFno.facade.CarManager;
import com.sbt.javaschool.rnd.lesson13GOFno.facade.factory.builder.Car;

public class Main {
    public static void main(String[] args) {
        System.out.println("Блондинка приходит в автосалон и обращается к продавцу");
        System.out.println("Здравствуйте, я бы хотела приобрести «Рено»");
        System.out.println(" Модель?");
        System.out.println(" Нет, секретарша. Но за комплимент спасибо!");

        System.out.println(" Консультант понял, и создал заказ");
        Car CarForBlondie = (new CarManager()).newOrder("Хочет машинку красненькую");
        if (CarForBlondie != null){
            System.out.println(CarForBlondie.toString());
        }
    }
}
