package com.entities;

public class Caini {

    private int Id;
    private String Name;
    private String Race;
    private int AngerScale;

    public Caini() {

    }

    public Caini(int Id, String name, String Race, int AngerScale) {
        this.Id = Id;
        this.Name = name;
        this.Race = Race;
        this.AngerScale = AngerScale;

    }

    public Caini(String name, String Race, int AngerScale) {
        this.Name = name;
        this.Race = Race;
        this.AngerScale = AngerScale;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setRace(String race) {
        Race = race;
    }

    public void setAngerScale(int angerScale) {
        AngerScale = angerScale;
    }

    public String getName() {
        return Name;
    }

    public String getRace() {
        return Race;
    }

    public int getAngerScale() {
        return AngerScale;
    }
}
