/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw11;

/**
 *
 * @author user
 */
public class Student implements Comparable<Student>{
private String name;
private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student student2) {
        /*if(name.equals(student2.getAge()))
        return 0;*/
       // return name.compareTo(student2.getName());
        if(age==student2.getAge())
            return 0;
        if(age>student2.getAge())
            return 1;
        
            return -1;
    }

}
