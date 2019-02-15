package com.chrissetiana.footypeeps.data.model.teams;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Squad {
    @SerializedName("id")
    @Expose
    public Integer playerId;

    @SerializedName("name")
    @Expose
    public String playerName;

    @SerializedName("position")
    @Expose
    public String playerPosition;

    public Squad(Integer playerId, String playerName, String playerPosition) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerPosition = playerPosition;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }
}
