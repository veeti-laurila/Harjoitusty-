package com.example.harjoitusty;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    private static Storage storage = null;

    public Storage() {

    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void listLutemons() {

    }
}
