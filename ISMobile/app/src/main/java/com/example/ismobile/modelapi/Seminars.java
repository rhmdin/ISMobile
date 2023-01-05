package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

public class Seminars {

    @SerializedName("room_id")
    private int roomId;

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

    @SerializedName("recommendation")
    private Object recommendation;

    @SerializedName("description")
    private Object description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("seminar_at")
    private String seminarAt;

    @SerializedName("file_journal")
    private String fileJournal;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("file_attendance")
    private Object fileAttendance;

    @SerializedName("online_url")
    private Object onlineUrl;

    @SerializedName("status")
    private int status;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public Object getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Object recommendation) {
        this.recommendation = recommendation;
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

    public String getSeminarAt() {
        return seminarAt;
    }

    public void setSeminarAt(String seminarAt) {
        this.seminarAt = seminarAt;
    }

    public String getFileJournal() {
        return fileJournal;
    }

    public void setFileJournal(String fileJournal) {
        this.fileJournal = fileJournal;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getFileAttendance() {
        return fileAttendance;
    }

    public void setFileAttendance(Object fileAttendance) {
        this.fileAttendance = fileAttendance;
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
