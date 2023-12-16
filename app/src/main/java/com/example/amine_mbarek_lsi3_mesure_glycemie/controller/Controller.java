package com.example.amine_mbarek_lsi3_mesure_glycemie.controller;

import com.example.amine_mbarek_lsi3_mesure_glycemie.model.Patient;

public class Controller {
    private Patient patient;
    private static Controller instance = null;

    public Controller(){
        super();
    };
    public static final Controller getInstance(){
        if(Controller.instance == null)
            Controller.instance = new Controller();
        return Controller.instance;
    }
    // Méthode pour initialiser le modèle par les propriétés d'un patient donné par l'utilisateur.
    public void createPatient(int age, float glucoseValue, boolean isFasting) {
        // Créez un nouvel objet Patient avec les informations fournies par l'utilisateur.
        this.patient = new Patient(age, glucoseValue, isFasting);
    }

    // Méthode pour retourner le résultat de l'analyse du niveau de glycémie.
    public String getResponse() {
        return this.patient.calculateGlucoseLevel();

    }
}
