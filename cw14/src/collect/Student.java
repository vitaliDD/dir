/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collect;

/**
 *
 * @author user
 */
public class Student {
    
    private String name;
    private int age;

    
    
   private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static class Builder{
    private String name;
    private int age;
    public Builder setName(String name) {
        this.name = name;
        return this;
    }
     public Builder setAge(int age) {
        this.age = age;
        return this;
    }
    public Student build() throws Exception{
        if(age==0){
        
        throw new Exception("age==0");
        }
        if(name.isEmpty()){
        throw new Exception("age==0");
        
        }    
        return new Student(name, age);
    
    
    }
    
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
    public String toString() {
        return "Student{" + "name=" + name + ", age=" + age + '}';
    }
    
    
}
