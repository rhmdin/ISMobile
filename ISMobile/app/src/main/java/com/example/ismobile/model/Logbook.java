package com.example.ismobile.model;

import android.util.Log;

public class Logbook {
    String tgl;
    String ket;
    int status;

    public Logbook(){}

    public Logbook(String tgl, String ket, int status) {
        this.tgl = tgl;
        this.ket = ket;
        this.status = status;
    }

    public String getTgl() {
        return tgl;
    }

    public String getKet() {
        return ket;
    }

    public int getStatus() {
        return status;
    }
}
