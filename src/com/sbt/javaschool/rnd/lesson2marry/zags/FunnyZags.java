package com.sbt.javaschool.rnd.lesson2marry.zags;

import java.time.Year;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

import com.sbt.javaschool.rnd.lesson2marry.person.Person;

public class FunnyZags {
    private ArrayList<Person> victims = new ArrayList<>();

    public FunnyZags AddPerson(Person p) {
        victims.add(p);
        return this;
    }

    public void Marry() {
        System.out.println(" Пробуем женить...");
        LocalDate ld = LocalDate.now();

        for(Person p:victims) {
            if (p.getAge() < 18 && p.getAge() >= 16) {
                System.out.println(p.getFirstName() + " до 18 жениться можно только со справкой по беременности, чешите за справкой ...");
                victims.clear();
                return;
            }
            if (p.getAge() < 16) {
                System.out.println(p.getFirstName() + " вам еще нет даже 16, чё припёрлись? Каникулы чтоли начались? До свидания ...");
                victims.clear();
                return;
            }
        }
        if (victims.size() == 1 && victims.get(0).getGender().contains("МУЖ")) {
            System.out.println("Э " + victims.get(0).getFirstName() + ", ну и чё ты сюда припёрся, тебе в общество 'БЕЗ БАБ'" + ", пока...");
            victims.clear();
            return;
        }
        if (victims.size() == 1 && victims.get(0).getGender().contains("ЖЕН")) {
            System.out.println("Э " + victims.get(0).getFirstName() + ", ну и чё ты сюда припёрлась, тебе в общество 'ЛЮБИТЕЛИ КОШАТНИЦ'" + ", пока...");
            victims.clear();
            return;
        }
        if (victims.size() > 2) {
            System.out.println(" Количество тёщ превышено!!!, брак запрещен, пока...");
            victims.clear();
            return;
        }
        if (victims.get(0).getGender().compareTo(victims.get(1).getGender())==0) {
            System.out.println(" Однополые браки у нас запрещены, валите отсюда...");
            victims.clear();
            return;
        }

        //ищем и разводим женатых
        for(Person p:victims) {
            if (p.getSpouse()!=null) {
                System.out.println("Разводим "+p.getLastName()+" и "+p.getSpouse().getLastName());
                divorce(p);//того кто собрался жениться
                divorce(p.getSpouse());// его уже бывшую вторую половину
            }
        }
            // если всё гуд то женим
        System.out.println("\nСегодня " + ld.getDayOfMonth() + " числа " + ld.getMonthValue() + " месяца " + Year.now() + " года в отделе ЗАГС " +
                        "Зажопинского района города Усть-Бобруйск регистрируется брак");

        victims.get(0).setSpouse(victims.get(1));//записали каждому супругов
        victims.get(1).setSpouse(victims.get(0));

        victims.forEach(p -> {
            p.setMarried(true);
            System.out.print(p.getLastName() + " " + p.getFirstName());
            if (p.getGender().contains("МУЖ")) {
                System.out.println("- МУЖЕНЁК");
            }
            if (p.getGender().contains("ЖЕН")) System.out.println("- ЖЕНУШКА");
        });
        System.out.println("Дорогие новобрачные, в жизни каждого человека бывают незабываемые дни и события." +
                " Сегодня такой день у вас - день рождения вашей семьи. " +
                "Уважаемые новобрачные, с полным соответствием по Российским законодательствам ваш брак зарегистрирован. И я торжественно объявляю вас мужем и женой! Поздравьте друг друга супружеским поцелуем. \n" +

                "В народе издавна существует традиция, в знак любви и верности новобрачные обмениваются кольцами. Я предлагаю и вам обменяться кольцами. \n" +

                "(Свидетели отходят в сторону. Приносят кольца. Первым кольцо надевает жених невесте, потом невеста жениху) . \n" +

                "А теперь, уважаемые супруги, разрешите вручить вам ваш первый семейный документ - свидетельство о заключении вашего брака. Поздравляю. \n" +

                "Дорогие молодожены, сегодня у вас особенный день, вы вступили в семейный союз любви и верности. Отныне вы муж и жена, создатели новой семьи и продолжатели рода своего. В семейной жизни проявляйте больше заботы, доброты, терпения и уважения друг к другу. Не забывайте и о тех, кто вырастил вас и воспитал - ваших родителях. А я желаю вам счастья, удачи и благополучия. \n" +

                "Уважаемые родители, я поздравляю вас с днем бракосочетания ваших детей. Пусть вам хватит терпения и мудрости помочь молодым создать крепкую и дружную семью, пусть союз ваших детей приносит вам только радость. И сегодня я приглашаю вас первыми поздравить молодых. ");

                victims.clear();
    }
    private void divorce(Person p){
        p.setSpouse(p);
    }
}
