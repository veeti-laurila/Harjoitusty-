package com.example.harjoitusty;

import java.util.ArrayList;

public class TrainingArea extends Storage {

    private ArrayList<Lutemon> lutemonsTrainingArea = new ArrayList<>();

    private static TrainingArea trainingArea = null;

    public TrainingArea() {

    }

    public static TrainingArea getInstance() {
        if (trainingArea == null) {
            trainingArea = new TrainingArea();
        }
        return trainingArea;
    }

    public void train(Lutemon lutemon) {
        lutemon.experience = lutemon.experience + 1;
    }

    public void addLutemonToTrainingArea(Lutemon lutemon) {
        lutemonsTrainingArea.add(lutemon);
    }

    public ArrayList<Lutemon> getLutemonsTrainingArea() {
        return lutemonsTrainingArea;
    }

    public void removeLutemonFromTraining(int id) {
        for (Lutemon lutemon : lutemonsTrainingArea) {
            if (lutemon.getID() == id) {
                break;
            }
        }
        lutemonsTrainingArea.remove(id);
    }
}
