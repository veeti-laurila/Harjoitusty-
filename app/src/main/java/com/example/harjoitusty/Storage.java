package com.example.harjoitusty;

import java.util.ArrayList;

public class Storage {

    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    private static Storage storage = null;

    public Storage() {
        lutemons.clear();
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    // Returns lutemons
    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    // Removes Lutemon from Storage
    public void removeLutemonFromStorage(int id) {
        Lutemon lutemonRemove = null;
        for (Lutemon lutemon : lutemons) {
            if (lutemon.getID() == id) {
                lutemonRemove = lutemon;
                break;
            }
        }
        if (lutemonRemove != null) {
            lutemons.remove(lutemonRemove);
        }
    }

    // Adds Lutemon to list
    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }
}
