package com.example.ismobile.modelapi.DetailMahasiswa;

import com.google.gson.annotations.SerializedName;

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
    private String examiners;
}
