package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("address")
    private Object address;

    @SerializedName("gender")
    private int gender;

    @SerializedName("year")
    private int year;

    @SerializedName("department_id")
    private int departmentId;

    @SerializedName("photo")
    private Object photo;

    @SerializedName("created_at")
    private Object createdAt;

    @SerializedName("religion")
    private Object religion;

    @SerializedName("nik")
    private String nik;

    @SerializedName("marital_status")
    private Object maritalStatus;

    @SerializedName("nim")
    private String nim;

    @SerializedName("birthplace")
    private String birthplace;

    @SerializedName("updated_at")
    private Object updatedAt;

    @SerializedName("phone")
    private String phone;

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    private int idThesis;

    @SerializedName("status")
    private int status;

    private String sejak;
    public Student(int idThesis, String name, String nim, String sejak) {
        this.idThesis = idThesis;
        this.name = name;
        this.nim = nim;
        this.sejak = sejak;
    }

    public void setIdThesis(int idThesis) {
        this.idThesis = idThesis;
    }

    public String getSejak() {
        return sejak;
    }

    public void setSejak(String sejak) {
        this.sejak = sejak;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setAddress(Object address){
        this.address = address;
    }

    public Object getAddress(){
        return address;
    }

    public void setGender(int gender){
        this.gender = gender;
    }

    public int getGender(){
        return gender;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return year;
    }

    public void setDepartmentId(int departmentId){
        this.departmentId = departmentId;
    }

    public int getDepartmentId(){
        return departmentId;
    }

    public void setPhoto(Object photo){
        this.photo = photo;
    }

    public Object getPhoto(){
        return photo;
    }

    public void setCreatedAt(Object createdAt){
        this.createdAt = createdAt;
    }

    public Object getCreatedAt(){
        return createdAt;
    }

    public void setReligion(Object religion){
        this.religion = religion;
    }

    public Object getReligion(){
        return religion;
    }

    public void setNik(String nik){
        this.nik = nik;
    }

    public String getNik(){
        return nik;
    }

    public void setMaritalStatus(Object maritalStatus){
        this.maritalStatus = maritalStatus;
    }

    public Object getMaritalStatus(){
        return maritalStatus;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public String getNim(){
        return nim;
    }

    public void setBirthplace(String birthplace){
        this.birthplace = birthplace;
    }

    public String getBirthplace(){
        return birthplace;
    }

    public void setUpdatedAt(Object updatedAt){
        this.updatedAt = updatedAt;
    }

    public Object getUpdatedAt(){
        return updatedAt;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public int getIdThesis(){
        return idThesis;
    }


    public void setStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
}
