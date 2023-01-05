package com.example.ismobile.modelapi;

import com.google.gson.annotations.SerializedName;

public class DetailMahasiswaPivot {
    @SerializedName("thesis_trial_id")
    private int thesis_trial_id;
    @SerializedName("examiner_id")
    private int examiner_id;
    @SerializedName("id")
    private int id;
    @SerializedName("position")
    private int position;

    public int getThesis_trial_id() {
        return thesis_trial_id;
    }

    public void setThesis_trial_id(int thesis_trial_id) {
        this.thesis_trial_id = thesis_trial_id;
    }

    public int getExaminer_id() {
        return examiner_id;
    }

    public void setExaminer_id(int examiner_id) {
        this.examiner_id = examiner_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
