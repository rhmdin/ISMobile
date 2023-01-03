package com.example.ismobile.modelapi.ListMhsBimbingan;

import com.google.gson.annotations.SerializedName;

public class ListBimbingan {

    @SerializedName("status")
    private String status;
    @SerializedName("count") //banyak bimbingan
    private String count;
    @SerializedName("theses")
    private String theses;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTheses() {
        return theses;
    }

    public void setTheses(String theses) {
        this.theses = theses;
    }
}
