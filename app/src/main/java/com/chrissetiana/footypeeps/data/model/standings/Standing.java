package com.chrissetiana.footypeeps.data.model.standings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Standing {

    @SerializedName("table")
    @Expose
    private List<Table> tableList;

    public List<Table> getTableList() {
        return tableList;
    }
}
