/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class Doctors {

    private int id;
    private String name;
    private String degree;
    private Date dateOfBirth;
    private int yearEperience;
    private ArrayList<String> type;
    private boolean visible;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getYearEperience() {
        return yearEperience;
    }

    public void setYearEperience(int yearEperience) {
        this.yearEperience = yearEperience;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\nDoctors{" + "id=" + id + ", name=" + name
                + ", degree=" + degree + ", "
                + "dateOfBirth=" + new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirth)
                + ", yearEperience=" + yearEperience + ", type=" + type
                + ", visible=" + visible + "}";
    }

}
