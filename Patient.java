package com.example.dentaldetectionapp;

public class Patient {
    private String Symptoms1;
    private String Symptoms2;
    private String Disease;

    public String getSymptoms1() {
        return Symptoms1;
    }

    public void setSymptoms1(String symptoms1) {
        Symptoms1 = symptoms1;
    }

    public String getSymptoms2() {
        return Symptoms2;
    }

    public void setSymptoms2(String symptoms2) {
        Symptoms2 = symptoms2;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public Patient() {
    }
}
