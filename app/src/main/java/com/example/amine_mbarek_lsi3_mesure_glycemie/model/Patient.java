package com.example.amine_mbarek_lsi3_mesure_glycemie.model;

public class Patient {
    private int age;
    private float glucoseValue;
    private boolean isFasting;

    public Patient(int age, float glucoseValue, boolean isFasting) {
        this.age = age;
        this.glucoseValue = glucoseValue;
        this.isFasting = isFasting;
    }


    public int getAge() {
        return age;
    }

    public float getGlucoseValue() {
        return glucoseValue;
    }

    public boolean isFasting() {
        return isFasting;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGlucoseValue(float glucoseValue) {
        this.glucoseValue = glucoseValue;
    }

    public void setFasting(boolean fasting) {
        isFasting = fasting;
    }

    public String calculateGlucoseLevel() {
        if (isFasting) {
            if (age > 13) {
                if (glucoseValue >= 5.0 && glucoseValue <= 7.2) {
                    return "Niveau de glycémie normal";
                } else if (glucoseValue < 5.0) {
                    return "Niveau de glycémie trop bas";
                } else if (glucoseValue > 7.2) {
                    return "Niveau de glycémie trop élevé";
                }
            } else if (age >= 6 && age <= 12) {
                if (glucoseValue >= 5.0 && glucoseValue <= 10.0) {
                    return "Niveau de glycémie normal";
                } else {
                    return "Niveau de glycémie trop bas";
                }
            } else if (age < 6) {
                if (glucoseValue >= 5.5 && glucoseValue <= 10.0) {
                    return "Niveau de glycémie normal";
                } else {
                    return "Niveau de glycémie trop bas";
                }
            }
        } else {
            if (glucoseValue < 10.5) {
                return "Niveau de glycémie normal";
            } else {
                return "Niveau de glycémie trop élevé";
            }
        }
        return "Niveau de glycémie inconnu";
    }
    //public static getResponse
}
