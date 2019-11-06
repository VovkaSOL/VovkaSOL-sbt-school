package com.sbt.javaschool.rnd.lesson2marry.zags;

import com.sbt.javaschool.rnd.lesson2marry.person.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class FunnyZagsTest implements AllTests {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Пошла жара, начато тестирование FunnyZagsTest.class");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("FunnyZagsTest.class тестирование завершено");
    }


    @Test
    @Override
    public void MainClassTest() {
        FunnyZags fz= new FunnyZags();
        fz.AddPerson(new Person("Валера","Жирнобрюхов",21,"МУЖ"));
        Assertions.assertEquals(false, fz.Marry());//Одного нельзя женить

        fz.AddPerson(new Person("Валера","Жирнобрюхов",21,"МУЖ"))
                .AddPerson(new Person("Светлана","Плоскодоскина",17,"ЖЕН"));
        Assertions.assertEquals(false, fz.Marry());//Девушке нет 18

        fz.AddPerson(new Person("Валера","Жирнобрюхов",21,"МУЖ"))
                .AddPerson(new Person("Светлана","Плоскодоскина",15,"ЖЕН"));
        Assertions.assertEquals(false, fz.Marry());//Девушке нет 18


        //К сожалению в задании написано что нужно проверить женитьбу однополых, поэтому придется проверять
        fz.AddPerson(new Person("Владимир","Соловьёв",42,"МУЖ"))
                .AddPerson(new Person("Дмитрий","Киселёв",48,"МУЖ"));
        Assertions.assertEquals(false, fz.Marry());//заднеприводные

        //пробуем женить женатого на замуженей ....
        fz.AddPerson(new Person("Валера","Жирнобрюхов",21,"МУЖ",
                /*женат на*/ new Person("Светлана","Плоскодоскина",35,"ЖЕН") ))
                .AddPerson(new Person("Наталья","Ротнезакрывайкина",20,"ЖЕН",
                        /*замужем за*/new Person("Дмитрий","Слепошаров",30,"МУЖ")));
        Assertions.assertEquals(true, fz.Marry()); //разводим и женим

        fz.AddPerson(new Person("Валера","Жирнобрюхов",21,"МУЖ"))
                .AddPerson(new Person("Наталья","Ротнезакрывайкина",20,"ЖЕН"));
        Assertions.assertEquals(true, fz.Marry());//всё норм, женим, должно вывалиться

    }
}