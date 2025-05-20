package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//abstract class that prevents instantiation and acts as a blueprint for child classes
public abstract class SuperPerson {

    //protected properties so they can possibly be access by our children, grand children, etc...
    //these properties stay in the family
    protected String name;
    protected int health;
    protected int experiencePoints;

    //create hashmap for battle log
    private HashMap<String, Integer> battleLog = new HashMap<String, Integer>();
    //create HashMap for inventory
    private HashMap<String, Integer> inventory = new HashMap<String, Integer>();


    public SuperPerson(String name, int health) {
        //take in the values for name and health
        this.name = name;
        this.health = health;

        //default the experience points to 0
        this.experiencePoints = 0;
    }

    //method to return if our SuperPerson is alive
    public boolean isAlive(){
        //if the health is greater than zero, return true, otherwise return false;
        return this.health > 0;

    }

    public String getType(){
        return this.getClass().getSimpleName();
    }

    //this methods allows a super person to take damage
    public void takeDamage(int damageAmount){
        //subtract the damage amount from the health
        //but we don't want ever set our health below 0
        this.health -= damageAmount;

        //health not allowed to go below zero
        if(this.health < 0){
            this.health = 0;
        }
    }

    //a way to ask the super person how they are doing.
    public String getStatus(){

        //build and return a string that tells us how the SuperPerson is doing
        return this.name + " has " + this.health + " health left!";

    }

    //update the log entry for our SuperPerson
    public void logHit(SuperPerson opponent) {
        String name = opponent.name;
        int count = battleLog.getOrDefault(name, 0);
        battleLog.put(name, count + 1);
    }

    public void printBattleLog() {
        System.out.println("Battle log for " + name + ":");
        for (HashMap.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    //add items to my inventory
    public void addPowerUp(String name, int value){
        inventory.put(name, value);
    }

    public int getPowerUpBonus(String name){

        //bonus damage has to start at something
        int bonusDamage = 0;

        //return the 0 bonus damage if we don't have that item
        if(!inventory.containsKey(name)){
            System.out.println(name + " does not exist in your inventory, 0 bonus damage");
            return bonusDamage;
        }

        //get the items damage
        bonusDamage = inventory.get(name);

        //print out what item we got
        System.out.println("The " + name + " has been equipped and will do " + bonusDamage + " extra damage");

        //return the damage modifier
        return bonusDamage;

    }

    public int getPowerUpBonusRandom(){
        int bonusDamage = 0;

        if (!inventory.isEmpty()) {
            //create a new list of just the keys from the HashMap (glove, hammer, etc....)
            ArrayList<String> items = new ArrayList<String>(inventory.keySet());

            //get a random item name from the above list we just made and store it in randomItem
            String randomItem = items.get(new Random().nextInt(items.size()));

            //get the point value for that item from the inventory HashMap
            //bonuse would be the int that represents the damage the item will do.
            bonusDamage = inventory.get(randomItem);

            System.out.println("The " + randomItem + " has been equipped and will do " + bonusDamage + " extra damage");

        }else{
            System.out.println("no items exist in your inventory, 0 bonus damage");
        }

        return bonusDamage;
    }
}
