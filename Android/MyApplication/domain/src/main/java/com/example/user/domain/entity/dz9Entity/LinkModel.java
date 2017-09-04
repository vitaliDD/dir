package com.example.user.domain.entity.dz9Entity;

import com.example.user.domain.entity.DomainModel;

import java.util.ArrayList;

/**
 * Created by user on 11.08.2017.
 */
public class LinkModel implements DomainModel{

    private ArrayList<String> stringArrayList=new ArrayList<>();

    public void setStringArrayList(ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }

    public LinkModel(ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }

    public ArrayList<String> getStringArrayList() {
        return stringArrayList;
    }
}
