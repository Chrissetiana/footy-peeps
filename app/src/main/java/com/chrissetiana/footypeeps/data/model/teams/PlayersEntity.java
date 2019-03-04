package com.chrissetiana.footypeeps.data.model.teams;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "players",
        indices = {
                @Index(value = "team_id"),
                @Index(value = "id", unique = true)},
        foreignKeys = @ForeignKey(entity = TeamsEntity.class,
                parentColumns = "id", childColumns = "team_id",
                onDelete = ForeignKey.CASCADE))
public class PlayersEntity {

    @ColumnInfo(name = "no")
    @PrimaryKey(autoGenerate = true)
    private int baseId;

    @ColumnInfo(name = "team_id")
    private Integer playerTeamId;

    @ColumnInfo(name = "id")
    private Integer playerId;

    @ColumnInfo(name = "name", index = true)
    private String playerName;

    @ColumnInfo(name = "position")
    private String playerPosition;

    @ColumnInfo(name = "shirt_no")
    private Integer playerNumber;

    public int getBaseId() {
        return baseId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public Integer getPlayerTeamId() {
        return playerTeamId;
    }

    public void setPlayerTeamId(Integer playerTeamId) {
        this.playerTeamId = playerTeamId;
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

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }
}
