package com.entities;

public class Pisici {
    private int Id;
    private String Name;
    private String Race;
    private int SoftnessScale;

    public Pisici() {

    }

    public Pisici(int id, String name, String race, int softnessScale) {
        this.Id = id;
        this.Name = name;
        this.Race = race;
        this.SoftnessScale = softnessScale;
    }

    public Pisici(String name, String race, int softnessScale) {
        this.Name = name;
        this.Race = race;
        this.SoftnessScale = softnessScale;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRace() {
        return Race;
    }

    public void setRace(String race) {
        Race = race;
    }

    public int getSoftnessScale() {
        return SoftnessScale;
    }

    public void setSoftnessScale(int softnessScale) {
        SoftnessScale = softnessScale;
    }
}
