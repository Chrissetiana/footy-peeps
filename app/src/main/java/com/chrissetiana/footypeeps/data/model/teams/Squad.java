package com.chrissetiana.footypeeps.data.model.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Squad {

    @SerializedName("id")
    @Expose
    private Integer playerId;

    @SerializedName("name")
    @Expose
    private String playerName;

    @SerializedName("position")
    @Expose
    private String playerPosition;

    @SerializedName("shirtNumber")
    @Expose
    private Integer playerShirtNumber;

    public Integer getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public Integer getPlayerShirtNumber() {
        return playerShirtNumber;
    }
}
