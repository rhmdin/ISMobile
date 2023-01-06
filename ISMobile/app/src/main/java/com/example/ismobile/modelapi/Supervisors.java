package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

public class Supervisors {

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("address")
    private Object address;

    @SerializedName("gender")
    private int gender;

    @SerializedName("department_id")
    private int departmentId;

    @SerializedName("npwp")
    private Object npwp;

    @SerializedName("photo")
    private Object photo;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("association_type")
    private int associationType;

    @SerializedName("religion")
    private int religion;

    @SerializedName("nik")
    private String nik;

    @SerializedName("marital_status")
    private int maritalStatus;

    @SerializedName("nip")
    private String nip;

    @SerializedName("karpeg")
    private Object karpeg;

    @SerializedName("birthplace")
    private String birthplace;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("phone")
    private String phone;

    @SerializedName("nidn")
    private String nidn;

    @SerializedName("name")
    private String name;

    @SerializedName("pivot")
    private DetailTAMahasiswaPivot pivot;

    @SerializedName("id")
    private int id;

    @SerializedName("status")
    private int status;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Object getNpwp() {
        return npwp;
    }

    public void setNpwp(Object npwp) {
        this.npwp = npwp;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getAssociationType() {
        return associationType;
    }

    public void setAssociationType(int associationType) {
        this.associationType = associationType;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public int getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Object getKarpeg() {
        return karpeg;
    }

    public void setKarpeg(Object karpeg) {
        this.karpeg = karpeg;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DetailTAMahasiswaPivot getPivot() {
        return pivot;
    }

    public void setPivot(DetailTAMahasiswaPivot pivot) {
        this.pivot = pivot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
