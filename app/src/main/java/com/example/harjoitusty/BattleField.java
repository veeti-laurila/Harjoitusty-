package com.example.harjoitusty;

import java.util.ArrayList;

public class BattleField extends Storage {

    private ArrayList<Lutemon> lutemonsBattleField = new ArrayList<>();

    private static BattleField battleField = null;

    public BattleField() {

    }

    public static BattleField getInstance() {
        if (battleField == null) {
            battleField = new BattleField();
        }
        return battleField;
    }

    public void addLutemonToBattleField(Lutemon lutemon) {
        lutemonsBattleField.add(lutemon);
    }

    public ArrayList<Lutemon> getLutemonsBattleField() {
        return lutemonsBattleField;
    }

    public void removeItemFromBattleField(int id) {
        for (Lutemon lutemon : lutemonsBattleField) {
            if (lutemon.getID() == id) {
                break;
            }
        }
        lutemonsBattleField.remove(id);
    }

    public void fight(Lutemon A, Lutemon B) {
        while (A.health > 0 && B.health > 0) {
            System.out.println("1: " + A.color + A.name + " hyökkäys: " + A.attack + "; puolustus: " + A.defense + "; kokemus: " + A.experience + "; elämä: " + A.health + "/" + A.maxHealth);
            System.out.println("2: " + B.color + B.name + " hyökkäys: " + B.attack + "; puolustus: " + B.defense + "; kokemus: " + B.experience + "; elämä: " + B.health + "/" + B.maxHealth);
            B.defense(A);
            if (B.health > 0) {
                System.out.println(B.color + B.name + " onnistui välttämään kuoleman.");
                A = B;
                B = A;
            } else {
                System.out.println(B.color + B.name + " kuoli.");
                A.experience = A.experience + 1;
                break;
            }
        }
        System.out.println("Taistelu päättyi.");
    }
}
