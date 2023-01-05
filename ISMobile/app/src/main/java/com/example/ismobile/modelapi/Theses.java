package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

public class Theses {

    @SerializedName("student")
    private Student student;

    @SerializedName("student_id")
    private int studentId;

    @SerializedName("grade_by")
    private Object gradeBy;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("abstract")
    private Object jsonMemberAbstract;

    @SerializedName("title")
    private Object title;

    @SerializedName("start_at")
    private String startAt;

    @SerializedName("created_by")
    private Object createdBy;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("grade")
    private Object grade;

    @SerializedName("id")
    private int id;

    @SerializedName("topic_id")
    private int topicId;

    @SerializedName("status")
    private int status;

    public void setStudent(Student student){
        this.student = student;
    }

    public Student getStudent(){
        return student;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public int getStudentId(){
        return studentId;
    }

    public void setGradeBy(Object gradeBy){
        this.gradeBy = gradeBy;
    }

    public Object getGradeBy(){
        return gradeBy;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setJsonMemberAbstract(Object jsonMemberAbstract){
        this.jsonMemberAbstract = jsonMemberAbstract;
    }

    public Object getJsonMemberAbstract(){
        return jsonMemberAbstract;
    }

    public void setTitle(Object title){
        this.title = title;
    }

    public Object getTitle(){
        return title;
    }

    public void setStartAt(String startAt){
        this.startAt = startAt;
    }

    public String getStartAt(){
        return startAt;
    }

    public void setCreatedBy(Object createdBy){
        this.createdBy = createdBy;
    }

    public Object getCreatedBy(){
        return createdBy;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setGrade(Object grade){
        this.grade = grade;
    }

    public Object getGrade(){
        return grade;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setTopicId(int topicId){
        this.topicId = topicId;
    }

    public int getTopicId(){
        return topicId;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
}
