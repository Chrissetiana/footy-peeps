package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Score {
    @SerializedName("fullTime")
    @Expose
    public FullTime fullTime;

    public Score(FullTime fullTime) {
        this.fullTime = fullTime;
    }

    public FullTime getFullTime() {
        return fullTime;
    }

    public void setFullTime(FullTime fullTime) {
        this.fullTime = fullTime;
    }
}
