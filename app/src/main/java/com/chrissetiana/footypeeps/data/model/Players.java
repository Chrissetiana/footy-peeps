package com.chrissetiana.footypeeps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Players {
    // for competition/teams (players)
    // https://api.football-data.org/v2/teams/{id}

    @SerializedName("squad")
    @Expose
    public List<Squad> playerList = null;

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
    }
}
