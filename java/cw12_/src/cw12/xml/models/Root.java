/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw12.xml.models;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Root {
    
    private String name;
    private ArrayList <People> people;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList <People> getPeople() {
        return people;
    }

    public void setPeople(ArrayList <People> people) {
        this.people = people;
    }
    
}
