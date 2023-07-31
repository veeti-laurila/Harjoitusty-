package com.example.harjoitusty;

import android.transition.Transition;

import java.io.Serializable;

public class Lutemon implements Serializable {

    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;

    protected int id;
    protected int picture;

    public Lutemon(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id, int picture) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.picture = picture;
    }

    // Returns name
    public String getName() {
        return name;
    }

    // Returns color
    public String getColor() {
        return color;
    }

    // Returns attack
    public int getAttack() {
        return attack;
    }

    // Sets new attack
    public void setAttack(int att) {
        attack = attack + att;
    }

    // Returns defense
    public int getDefense() {
        return defense;
    }

    // Returns experience
    public int getExperience() {
        return experience;
    }

    // Sets new experience
    public void setExperience(int exp) {
        experience = experience + exp;
    }

    // Returns health
    public int getHealth() {
        return health;
    }

    // Sets new health
    public void setHealth(int heal) {
        health = heal;
    }

    // Returns maxHealth
    public int getMaxHealth() {
        return maxHealth;
    }

    // Returns ID
    public int getID() {
        return id;
    }

    // Returns picture
    public int getPicture() {
        return picture;
    }

    // Decreases health from the attack
    public int defense(Lutemon lutemon) {
        health = health - (lutemon.attack - defense);
        return health;
    }
}
