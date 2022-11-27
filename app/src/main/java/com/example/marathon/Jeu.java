package com.example.marathon; // A remplacer par votre package

import java.time.OffsetDateTime;

public class Jeu {
    private long id;
    private String JOUEUR1;
    private String JOUEUR2;
    private int SCORE;
    private String TEMPS;
    private String DATE;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJOUEUR1() {
        return JOUEUR1;
    }

    public void setJOUEUR1(String JOUEUR1) {
        this.JOUEUR1 = JOUEUR1;
    }

    public String getJOUEUR2() {
        return JOUEUR2;
    }

    public void setJOUEUR2(String JOUEUR2) {
        this.JOUEUR2 = JOUEUR2;
    }

    public int getSCORE() {
        return SCORE;
    }

    public void setSCORE(int LANCE) {
        this.SCORE = SCORE;
    }

    public String getTEMPS() {
        return TEMPS;
    }

    public void setTEMPS(String TEMPS) {
        this.TEMPS = TEMPS;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }
}