package com.example.user.cw1.dz7;

/**
 * Created by ya on 13.08.2017.
 */

public class User {

    private int age;
    private String sex;
    private String name;
    private String surname;
    private String imageUrl;


    public User(int age, String sex, String name, String surname, String url) {
        this.age = age;
        this.sex = sex;
        this.name = name;
        this.surname = surname;
        this.imageUrl = url;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}