package com.example.ismobile.modelapi.ListMhsBimbingan;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("id")
    private int id;
    @SerializedName("nik")
    private int nik;
    @SerializedName("nim")
    private int nim;
    @SerializedName("name")
    private int name;
    @SerializedName("year")
    private int year;
    @SerializedName("gender")
    private int gender;
    @SerializedName("birthday")
    private int birthday;
    @SerializedName("birthplace")
    private int birthplace;
    @SerializedName("phone")
    private int phone;
    @SerializedName("address")
    private int address;
    @SerializedName("department_id")
    private int department_id;
    @SerializedName("photo")
    private int photo;
    @SerializedName("marital_status")
    private int marital_status;
    @SerializedName("religion")
    private int religion;
    @SerializedName("status")
    private int status;
    @SerializedName("created_at")
    private int created_at;
    @SerializedName("updated_at")
    private int updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNik() {
        return nik;
    }

    public void setNik(int nik) {
        this.nik = nik;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(int birthplace) {
        this.birthplace = birthplace;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(int marital_status) {
        this.marital_status = marital_status;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }
}
