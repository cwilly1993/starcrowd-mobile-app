package com.example.starcrowdinvestorapp.Entities;

public class Campaign {
    private int id;
    private String date;
    private int artistId;
    private int moneyGoal;
    private int perkPkgId;
    private String status;

    public Campaign(int id, String date, int artistId, int moneyGoal, int perkPkgId, String status) {
        this.id = id;
        this.date = date;
        this.artistId = artistId;
        this.moneyGoal = moneyGoal;
        this.perkPkgId = perkPkgId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getMoneyGoal() {
        return moneyGoal;
    }

    public void setMoneyGoal(int moneyGoal) {
        this.moneyGoal = moneyGoal;
    }

    public int getPerkPkgId() {
        return perkPkgId;
    }

    public void setPerkPkgId(int perkPkgId) {
        this.perkPkgId = perkPkgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
