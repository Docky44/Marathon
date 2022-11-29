package com.example.marathon;

import java.time.OffsetDateTime;

public class Jeu {
    private long id;
    private String JOUEUR1;
    private String JOUEUR2;
    private int DISTANCE1;
    private int SCORE1;
    private int DISTANCE2;
    private int SCORE2;
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

    public int getDISTANCE1() {
        return DISTANCE1;
    }

    public void setDISTANCE1(int DISTANCE1) {
        this.DISTANCE1 = DISTANCE1;
    }

    public int getDISTANCE2() {
        return DISTANCE2;
    }

    public void setDISTANCE2(int DISTANCE2) {
        this.DISTANCE2 = DISTANCE2;}

    public int getSCORE1() {
        return SCORE1;
    }

    public void setSCORE1(int SCORE1) {
        this.SCORE1 = SCORE1;
    }

    public int getSCORE2() {
        return SCORE2;
    }

    public void setSCORE2(int SCORE2) {
        this.SCORE2 = SCORE2;
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