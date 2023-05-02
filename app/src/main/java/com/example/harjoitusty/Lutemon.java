package com.example.harjoitusty;

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
    private int idCounter;

    public Lutemon(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getID() {
        return id;
    }

    public int defense(Lutemon lutemon) {
        health = health - lutemon.attack;
        return health;
    }

    public int attack(Lutemon lutemon) {
        System.out.println(lutemon.getName() + " (" + lutemon.getColor() + ") hyökkää");
        return attack;
    }

    /*public int getNumberOfCreatedLutemons() {
        int numberOfCreatedLutemons;
        return numberOfCreatedLutemons;
    }*/
}
