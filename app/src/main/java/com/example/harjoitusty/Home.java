package com.example.harjoitusty;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Home extends Storage {

    protected ArrayList<Lutemon> lutemonsHome = new ArrayList<>();
    protected ArrayList<Lutemon> lutemonsMovedToHome = new ArrayList<>();

    private static Home home = null;

    public Home() {

    }

    public static Home getInstance() {
        if (home == null) {
            home = new Home();
        }
        return home;
    }

    // Adds Lutemon to list and sets Lutemon's health to max
    public void createLutemon(Lutemon lutemon) {
        lutemonsHome.add(lutemon);
        lutemon.setHealth(lutemon.getMaxHealth());
    }

    // Adds Lutemon to list that includes Lutemons that were moved back home from training area or battlefield
    public void addLutemonToLutemonsMovedToHome(Lutemon lutemon) {
        lutemonsMovedToHome.add(lutemon);
        lutemon.setHealth(lutemon.getMaxHealth());
    }

    // Return lutemonsMovedToHome list
    public ArrayList<Lutemon> getLutemonsMovedToHome() {
        return lutemonsMovedToHome;
    }

    // Removes Lutemon from Home
    public void removeLutemonFromHome(int id) {
        Lutemon lutemonRemove = null;
        for (Lutemon lutemon : lutemonsHome) {
            if (lutemon.getID() == id) {
                lutemonRemove = lutemon;
                break;
            }
        }
        if (lutemonRemove != null) {
            lutemonsHome.remove(lutemonRemove);
        }
    }

    // Returns lutemonsHome list
    public ArrayList<Lutemon> getLutemonsHome() {
        return lutemonsHome;
    }
}