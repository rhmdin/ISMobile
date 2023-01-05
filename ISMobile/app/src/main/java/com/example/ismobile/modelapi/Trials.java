package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

public class Trials {

    @SerializedName("room_id")
    private Object roomId;

    @SerializedName("end_at")
    private Object endAt;

    @SerializedName("thesis_id")
    private int thesisId;

    @SerializedName("file_slide")
    private String fileSlide;

    @SerializedName("registered_at")
    private String registeredAt;

    @SerializedName("method")
    private int method;

    @SerializedName("file_report")
    private String fileReport;

    @SerializedName("description")
    private Object description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("thesis_rubric_id")
    private int thesisRubricId;

    @SerializedName("start_at")
    private Object startAt;

    @SerializedName("file_journal")
    private String fileJournal;

    @SerializedName("score")
    private Object score;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("grade")
    private Object grade;

    @SerializedName("trial_at")
    private Object trialAt;

    @SerializedName("id")
    private int id;

    @SerializedName("online_url")
    private Object onlineUrl;

    @SerializedName("status")
    private int status;

    public Object getRoomId() {
        return roomId;
    }

    public void setRoomId(Object roomId) {
        this.roomId = roomId;
    }

    public Object getEndAt() {
        return endAt;
    }

    public void setEndAt(Object endAt) {
        this.endAt = endAt;
    }

    public int getThesisId() {
        return thesisId;
    }

    public void setThesisId(int thesisId) {
        this.thesisId = thesisId;
    }

    public String getFileSlide() {
        return fileSlide;
    }

    public void setFileSlide(String fileSlide) {
        this.fileSlide = fileSlide;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public String getFileReport() {
        return fileReport;
    }

    public void setFileReport(String fileReport) {
        this.fileReport = fileReport;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getThesisRubricId() {
        return thesisRubricId;
    }

    public void setThesisRubricId(int thesisRubricId) {
        this.thesisRubricId = thesisRubricId;
    }

    public Object getStartAt() {
        return startAt;
    }

    public void setStartAt(Object startAt) {
        this.startAt = startAt;
    }

    public String getFileJournal() {
        return fileJournal;
    }

    public void setFileJournal(String fileJournal) {
        this.fileJournal = fileJournal;
    }

    public Object getScore() {
        return score;
    }

    public void setScore(Object score) {
        this.score = score;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getGrade() {
        return grade;
    }

    public void setGrade(Object grade) {
        this.grade = grade;
    }

    public Object getTrialAt() {
        return trialAt;
    }

    public void setTrialAt(Object trialAt) {
        this.trialAt = trialAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getOnlineUrl() {
        return onlineUrl;
    }

    public void setOnlineUrl(Object onlineUrl) {
        this.onlineUrl = onlineUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
