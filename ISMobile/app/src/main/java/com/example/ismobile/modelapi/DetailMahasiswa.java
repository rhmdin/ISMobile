package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailMahasiswa {

    @SerializedName("id")
    private int id;
    @SerializedName("thesis_id")
    private int thesis_id;
    @SerializedName("thesis_rubric_id")
    private int thesis_rubric_id;
    @SerializedName("file_report")
    private String file_report;
    @SerializedName("file_slide")
    private String file_slide;
    @SerializedName("file_journal")
    private String file_journal;
    @SerializedName("status")
    private int status;
    @SerializedName("registered_at")
    private String registered_at;
    @SerializedName("method")
    private int method;
    @SerializedName("trial_at")
    private String trial_at;
    @SerializedName("start_at")
    private String start_at;
    @SerializedName("end_at")
    private String end_at;
    @SerializedName("room_id")
    private String room_id;
    @SerializedName("online_url")
    private String online_url;
    @SerializedName("score")
    private String score;
    @SerializedName("grade")
    private String grade;
    @SerializedName("description")
    private String description;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("examiners")
    private List<Examiners> examiners;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThesis_id() {
        return thesis_id;
    }

    public void setThesis_id(int thesis_id) {
        this.thesis_id = thesis_id;
    }

    public int getThesis_rubric_id() {
        return thesis_rubric_id;
    }

    public void setThesis_rubric_id(int thesis_rubric_id) {
        this.thesis_rubric_id = thesis_rubric_id;
    }

    public String getFile_report() {
        return file_report;
    }

    public void setFile_report(String file_report) {
        this.file_report = file_report;
    }

    public String getFile_slide() {
        return file_slide;
    }

    public void setFile_slide(String file_slide) {
        this.file_slide = file_slide;
    }

    public String getFile_journal() {
        return file_journal;
    }

    public void setFile_journal(String file_journal) {
        this.file_journal = file_journal;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRegistered_at() {
        return registered_at;
    }

    public void setRegistered_at(String registered_at) {
        this.registered_at = registered_at;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public String getTrial_at() {
        return trial_at;
    }

    public void setTrial_at(String trial_at) {
        this.trial_at = trial_at;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getOnline_url() {
        return online_url;
    }

    public void setOnline_url(String online_url) {
        this.online_url = online_url;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Examiners> getExaminers() {
        return examiners;
    }

    public void setExaminers(List<Examiners> examiners) {
        this.examiners = examiners;
    }
}
