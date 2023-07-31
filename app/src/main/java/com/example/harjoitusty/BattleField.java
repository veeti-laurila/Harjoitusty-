package com.example.harjoitusty;

import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BattleField extends Storage {

    protected ArrayList<Lutemon> lutemonsBattleField = new ArrayList<>();
    protected ArrayList<Lutemon> removedLutemons = new ArrayList<>();
    protected ArrayList<Lutemon> experiencedLutemons = new ArrayList<>();

    private static BattleField battleField = null;

    public BattleField() {

    }

    public static BattleField getInstance() {
        if (battleField == null) {
            battleField = new BattleField();
        }
        return battleField;
    }

    // Adds Lutemon to BattleField list
    public void addLutemonToBattleField(Lutemon lutemon) {
        lutemonsBattleField.add(lutemon);
    }

    // Returns BattleField's Lutemons
    public ArrayList<Lutemon> getLutemonsBattleField() {
        return lutemonsBattleField;
    }

    // Removes Lutemon from BattleField's list
    public void removeLutemonFromBattleField(int id) {
        Lutemon lutemonRemove = null;
        for (Lutemon lutemon : lutemonsBattleField) {
            if (lutemon.getID() == id) {
                lutemonRemove = lutemon;
                break;
            }
        }
        if (lutemonRemove != null) {
            lutemonsBattleField.remove(lutemonRemove);
        }
    }

    // Adds Lutemon to removedLutemons list
    public void addLutemonToRemovedLutemons(Lutemon lutemon) {
        removedLutemons.add(lutemon);
    }

    // Returns removedLutemons list
    public ArrayList<Lutemon> getRemovedLutemons() {
        return removedLutemons;
    }

    // Adds Lutemon to experiencedLutemons list
    public void addLutemonToExperiencedLutemons(Lutemon lutemon) {
        experiencedLutemons.add(lutemon);
    }

    // Returns experiencedLutemons list
    public ArrayList<Lutemon> getExperiencedLutemons() {
        return experiencedLutemons;
    }

    // Prints the fight and removes the Lutemon that lost the battle
    public void fight(Lutemon A, Lutemon B, TextView textView) {
        textView.append("1: " + A.getColor() + "(" + A.getName() + ")" + " att: " + A.getAttack() + "; def: " + A.getDefense() + "; exp: " + A.getExperience() + "; health: " + A.getHealth() + "/" + A.getMaxHealth() + "\n");
        textView.append("2: " + B.getColor() + "(" + B.getName() + ")" + " att: " + B.getAttack() + "; def: " + B.getDefense() + "; exp: " + B.getExperience() + "; health: " + B.getHealth() + "/" + B.getMaxHealth() + "\n");

        while (A.getHealth() > 0 && B.getHealth() > 0) {
            int healthB = B.defense(A);
            B.setHealth(healthB);
            textView.append(A.getColor() + "(" + A.getName() + ")" + " attacks " + B.getColor() + "(" + B.getName() + ")\n");
            if (B.getHealth() > 0) {
                textView.append(B.getColor() + "(" + B.getName() + ")" + " manages to escape death.\n");
                textView.append("2: " + B.getColor() + "(" + B.getName() + ")" + " att: " + B.getAttack() + "; def: " + B.getDefense() + "; exp: " + B.getExperience() + "; health: " + B.getHealth() + "/" + B.getMaxHealth() + "\n");
                textView.append("1: " + A.getColor() + "(" + A.getName() + ")" + " att: " + A.getAttack() + "; def: " + A.getDefense() + "; exp: " + A.getExperience() + "; health: " + A.getHealth() + "/" + A.getMaxHealth() + "\n");
            } else {
                textView.append(B.getColor() + "(" + B.getName() + ")" + " gets killed.\n");
                addLutemonToExperiencedLutemons(A);
                A.setExperience(1);
                break;
            }

            int healthA = A.defense(B);
            A.setHealth(healthA);
            textView.append(B.getColor() + "(" + B.getName() + ")" + " attacks " + A.getColor() + "(" + A.getName() + ")\n");
            if (A.getHealth() > 0) {
                textView.append(A.getColor() + "(" + A.getName() + ")" + " manages to escape death.\n");
                textView.append("1: " + A.getColor() + "(" + A.getName() + ")" + " att: " + A.getAttack() + "; def: " + A.getDefense() + "; exp: " + A.getExperience() + "; health: " + A.getHealth() + "/" + A.getMaxHealth() + "\n");
                textView.append("2: " + B.getColor() + "(" + B.getName() + ")" + " att: " + B.getAttack() + "; def: " + B.getDefense() + "; exp: " + B.getExperience() + "; health: " + B.getHealth() + "/" + B.getMaxHealth() + "\n");
            } else {
                textView.append(A.getColor() + "(" + A.getName() + ")" + " gets killed.\n");
                addLutemonToExperiencedLutemons(B);
                A.setExperience(1);
                break;
            }
        }
        textView.append("The battle is over.\n");

        if (A.getHealth() <= 0) {
            int idA = A.getID();
            BattleField.getInstance().removeLutemonFromBattleField(idA);
            Storage.getInstance().removeLutemonFromStorage(idA);
            addLutemonToRemovedLutemons(A);
        } else {
            int idB = B.getID();
            BattleField.getInstance().removeLutemonFromBattleField(idB);
            Storage.getInstance().removeLutemonFromStorage(idB);
            addLutemonToRemovedLutemons(B);
        }
    }
}
