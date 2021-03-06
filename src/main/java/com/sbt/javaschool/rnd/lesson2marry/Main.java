package com.sbt.javaschool.rnd.lesson2marry;
import com.sbt.javaschool.rnd.lesson2marry.person.Person;
import com.sbt.javaschool.rnd.lesson2marry.zags.FunnyZags;

public class Main {//

    public static void main(String[] args) {
        FunnyZags fz= new FunnyZags();
        fz.AddPerson(new Person("Валера","Жирнобрюхов",21,"МУЖ"))
                .Marry();
        //res Э Валера, ну и чё ты сюда припёрся, тебе в общество 'БЕЗ БАБ', пока...

        fz.AddPerson(new Person("Валера","Жирнобрюхов",21,"МУЖ"))
                .AddPerson(new Person("Светлана","Плоскодоскина",17,"ЖЕН"))
                .Marry();
        //res Светлана до 18 жениться можно только со справкой по беременности, чешите за справкой ...

        fz.AddPerson(new Person("Валера","Жирнобрюхов",21,"МУЖ"))
                .AddPerson(new Person("Светлана","Плоскодоскина",15,"ЖЕН"))
                .Marry();
        //res Светлана Вам еще нет даже 16, чё припёрлись? Каникулы чтоли начались? До свидания ...


        //К сожалению в задании написано что нужно проверить женитьбу однополых, поэтому придется проверять
        fz.AddPerson(new Person("Владимир","Соловьёв",42,"МУЖ"))
                .AddPerson(new Person("Дмитрий","Киселёв",48,"МУЖ"))
                .Marry();
        //res Однополые браки у нас запрещены, валите отсюда...

        //пробуем женить женатого на замуженей ....
        fz.AddPerson(new Person("Валера","Жирнобрюхов",21,"МУЖ",
                                         /*женат на*/ new Person("Светлана","Плоскодоскина",35,"ЖЕН") ))
                .AddPerson(new Person("Наталья","Ротнезакрывайкина",20,"ЖЕН",
                                        /*замужем за*/new Person("Дмитрий","Слепошаров",30,"МУЖ")))
                .Marry();
        //res Разводим Жирнобрюхов и Плоскодоскина
        //    Разводим Ротнезакрывайкина и Слепошаров
        //res Сегодня 29 числа 10 месяца 2019 года в отделе ЗАГС Зажопинского района города Усть-Бобруйск регистрируется брак
        //Жирнобрюхов Валера- МУЖЕНЁК
        //Ротнезакрывайкина Наталья- ЖЕНУШКА

        //пока Валере не везёт, но он не отчаивается...
        fz.AddPerson(new Person("Валера","Жирнобрюхов",21,"МУЖ"))
                .AddPerson(new Person("Наталья","Ротнезакрывайкина",20,"ЖЕН"))
                .Marry();
       //res Сегодня 29 числа 10 месяца 2019 года в отделе ЗАГС Зажопинского района города Усть-Бобруйск регистрируется брак
        //Жирнобрюхов Валера- МУЖЕНЁК
        //Ротнезакрывайкина Наталья- ЖЕНУШКА .........




       //
    }
}
