package com.example.demo.dto;

public class Person {

    String name;
    String id;

    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String profession;
    int age;
}
