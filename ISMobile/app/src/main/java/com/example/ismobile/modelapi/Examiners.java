package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

public class Examiners {
    @SerializedName("id")
    private int id;
    @SerializedName("nik")
    private String nik;
    @SerializedName("name")
    private String name;
    @SerializedName("nip")
    private String nip;
    @SerializedName("nidn")
    private String nidn;
    @SerializedName("karpeg")
    private String karpeg;
    @SerializedName("npwp")
    private String npwp;
    @SerializedName("gender")
    private String gender;
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("birthplace")
    private String birthplace;
    @SerializedName("phone")
    private String phone;
    @SerializedName("address")
    private String address;
    @SerializedName("department_id")
    private int department_id;
    @SerializedName("photo")
    private String photo;
    @SerializedName("marital_status")
    private int marital_status;
    @SerializedName("religion")
    private String religion;
    @SerializedName("association_type")
    private int association_type;
    @SerializedName("status")
    private int status;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("pivot")
    private DetailMahasiswaPivot pivot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getKarpeg() {
        return karpeg;
    }

    public void setKarpeg(String karpeg) {
        this.karpeg = karpeg;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(int marital_status) {
        this.marital_status = marital_status;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public int getAssociation_type() {
        return association_type;
    }

    public void setAssociation_type(int association_type) {
        this.association_type = association_type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public DetailMahasiswaPivot getPivot() {
        return pivot;
    }

    public void setPivot(DetailMahasiswaPivot pivot) {
        this.pivot = pivot;
    }
}
