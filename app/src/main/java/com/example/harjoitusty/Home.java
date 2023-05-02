package com.example.harjoitusty;

import java.util.ArrayList;

public class Home extends Storage {

    private ArrayList<Lutemon> lutemonsHome = new ArrayList<>();


    private static Home home = null;
    public Home() {

    }

    public static Home getInstance() {
        if (home == null) {
            home = new Home();
        }
        return home;
    }

    public void createLutemon(Lutemon lutemon) {
        lutemonsHome.add(lutemon);
        lutemon.health = lutemon.maxHealth;
    }

    public void removeLutemonFromHome(int id) {
        for (Lutemon lutemon : lutemonsHome) {
            if (lutemon.getID() == id) {
                break;
            }
        }
        lutemonsHome.remove(id);
    }

    public ArrayList<Lutemon> getLutemonsHome() {
        return lutemonsHome;
    }
}