package com.example.user.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 11.08.2017.
 */
public class cw12Profile  implements DataModel  {

    private String name;
    private String surname;
    private int age;

    @SerializedName("objectId")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
       this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "cw12Profile{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }
}
