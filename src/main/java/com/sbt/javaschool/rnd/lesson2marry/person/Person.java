package com.sbt.javaschool.rnd.lesson2marry.person;

import java.util.ArrayList;

public class Person {


    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private boolean married;
    private ArrayList<Person> spouses = new ArrayList<>();//пришлось сделать массивом, так как в java нельзя объект сделать обратно null
    public  Person(String firstName, String lastName, int age, String gender) {
       this.firstName=firstName;
       this.lastName=lastName;
       this.age=age;
       this.gender=gender;
       this.married=false;
    }

// конструктор для женатиков
    public  Person(String firstName, String lastName, int age, String gender, Person spouse) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.gender=gender;
        this.married=false;
        this.setSpouse(spouse);
    }





    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setMarried(boolean m) {
        this.married=m;
    }
    public Person getSpouse() {
        if(spouses.size()>0)  return this.spouses.get(0);
        else return null;
    }

    public void setSpouse(Person spouse) {
        this.spouses.clear();
        spouses.add(spouse);
    }
    public void resetSpouse() {
        this.spouses.clear();
    }
}
