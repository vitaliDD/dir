package cw13;

import com.google.gson.annotations.SerializedName;



public class People {
private int age;
private int id;
//@SerializedName("is_degree")
@SerializedName("is_degree")
private boolean IsDegree;
private String name;
private String surname;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsDegree() {
        return IsDegree;
    }

    public void setIsDegree(boolean IsDegree) {
        this.IsDegree = IsDegree;
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

    @Override
    public String toString() {
        return "People{" + "age=" + age + ", id=" + id + 
                ", IsDegree=" + IsDegree + ", name=" + name + ", surname=" + surname + '}';
    }

    
    
}
