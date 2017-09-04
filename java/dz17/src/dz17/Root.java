/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz17;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Root {
    
    private String name;
    private String location;
    private ArrayList <Doctors> doctors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctors> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Root{" + "name=" + name + ", location=" + location + ", doctors=" + doctors + '}';
    }

    
    
}
