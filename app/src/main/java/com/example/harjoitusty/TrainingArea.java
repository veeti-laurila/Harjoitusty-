package com.example.harjoitusty;

import androidx.recyclerview.widget.ListUpdateCallback;

import java.util.ArrayList;

public class TrainingArea extends Storage {

    private ArrayList<Lutemon> lutemonsTrainingArea = new ArrayList<>();
    private ArrayList<Lutemon> trainedLutemons = new ArrayList<>();

    private static TrainingArea trainingArea = null;

    public TrainingArea() {

    }

    public static TrainingArea getInstance() {
        if (trainingArea == null) {
            trainingArea = new TrainingArea();
        }
        return trainingArea;
    }

    // Adds Lutemon to trainedLutemons list and sets new attack
    public void train(Lutemon lutemon) {
        addLutemonToTrainedLutemons(lutemon);
        lutemon.setAttack(1);
    }

    // Adds Lutemon to list
    public void addLutemonToTrainingArea(Lutemon lutemon) {
        lutemonsTrainingArea.add(lutemon);
    }

    // Returns lutemonsTrainingArea list
    public ArrayList<Lutemon> getLutemonsTrainingArea() {
        return lutemonsTrainingArea;
    }

    // Adds Lutemon to trainedLutemons list
    public void addLutemonToTrainedLutemons(Lutemon lutemon) {
        trainedLutemons.add(lutemon);
    }

    // Returns trainedLutemons list
    public ArrayList<Lutemon> getTrainedLutemons() {
        return trainedLutemons;
    }

    // Removes Lutemon from list
    public void removeLutemonFromTraining(int id) {
        Lutemon lutemonRemove = null;
        for (Lutemon lutemon : lutemonsTrainingArea) {
            if (lutemon.getID() == id) {
                lutemonRemove = lutemon;
                break;
            }
        }
        if (lutemonRemove != null) {
            lutemonsTrainingArea.remove(lutemonRemove);
        }
    }
}
