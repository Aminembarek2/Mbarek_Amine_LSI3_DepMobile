package com.example.amine_mbarek_lsi3_mesure_glycemie.controller;

import com.example.amine_mbarek_lsi3_mesure_glycemie.model.Patient;

public class Controller {
    private Patient patient;

    public void setPatientData(int age, float glucoseValue, boolean isFasting) {
        patient.setAge(age);
        patient.setGlucoseValue(glucoseValue);
        patient.setFasting(isFasting);
    }

    public String calculateGlucoseLevel() {
        // Call the model's method to calculate the glucose level
        return patient.calculateGlucoseLevel();
    }
}
