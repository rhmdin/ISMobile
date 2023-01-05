package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailTAMahasiswa {

    @SerializedName("student")
    private Student student;

    @SerializedName("student_id")
    private int studentId;

    @SerializedName("grade_by")
    private String gradeBy;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("abstract")
    private String abstrak;

    @SerializedName("title")
    private String title;

    @SerializedName("start_at")
    private String startAt;

    @SerializedName("created_by")
    private int createdBy;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("trials")
    private List<Trials> trials;

    @SerializedName("seminars")
    private List<Seminars> seminars;

    @SerializedName("grade")
    private String grade;

    @SerializedName("id")
    private int id;

    @SerializedName("topic_id")
    private int topicId;

    @SerializedName("status")
    private int status;

    @SerializedName("supervisors")
    private List<Supervisors> supervisors;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getGradeBy() {
        return gradeBy;
    }

    public void setGradeBy(String gradeBy) {
        this.gradeBy = gradeBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAbstrak() {
        return abstrak;
    }

    public void setAbstrak(String abstrak) {
        this.abstrak = abstrak;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Trials> getTrials() {
        return trials;
    }

    public void setTrials(List<Trials> trials) {
        this.trials = trials;
    }

    public List<Seminars> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminars> seminars) {
        this.seminars = seminars;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Supervisors> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(List<Supervisors> supervisors) {
        this.supervisors = supervisors;
    }
}
