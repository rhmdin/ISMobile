package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListBimbingan {

    @SerializedName("count")
    private int count;

    @SerializedName("theses")
    private List<Theses> theses;

    @SerializedName("status")
    private String status;

    public void setCount(int count){
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public void setTheses(List<Theses> theses){
        this.theses = theses;
    }

    public List<Theses> getTheses(){
        return theses;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
