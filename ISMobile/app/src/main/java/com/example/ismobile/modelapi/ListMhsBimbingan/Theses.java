package com.example.ismobile.modelapi.ListMhsBimbingan;

import com.google.gson.annotations.SerializedName;

public class Theses {
    @SerializedName("id")
    private int id;
    @SerializedName("topic_id")
    private int topic_id;
    @SerializedName("student_id")
    private int student_id;
    @SerializedName("title")
    private String title;
    @SerializedName("abstract")
    private String abstrak;
    @SerializedName("start_at")
    private String start_at;
    @SerializedName("status")
    private int status;
    @SerializedName("grade")
    private String grade;
    @SerializedName("grade_by")
    private String grade_by;
    @SerializedName("created_by")
    private String created_by;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("student")
    private String student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstrak() {
        return abstrak;
    }

    public void setAbstrak(String abstrak) {
        this.abstrak = abstrak;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade_by() {
        return grade_by;
    }

    public void setGrade_by(String grade_by) {
        this.grade_by = grade_by;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
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

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
}
