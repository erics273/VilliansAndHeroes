package com.pluralsight;

import java.util.Random;

public class SuperVillain extends SuperPerson {

    public SuperVillain(String name, int health, int evilness) {

        //call the parent constructor with the super() method
        super(name, health);

        //set the experiencePoints to the evilness value
        this.experiencePoints = evilness;

    }

    @Override
    public void fight(SuperPerson opponent){

        //generate a random number of damage to do
        Random rand = new Random();
        //return a whole number between 0 and 101 inculusive of the 0 but not the 101 (0-100)
        int baseDamage = rand.nextInt(101); //really means 0-100

        //lets make the total damage interesting by taking into account our experiencePoints
        int totalDamage = baseDamage + this.experiencePoints;

        //determine if we missed or hit based on the baseDamage
        //if we got a 0 for the base damage we missed
        //otherwise we landed our attack on our opponent and took the damage away from their health
        if(baseDamage == 0){
            System.out.println(this.getName() + "  Fires a sneaky blast.....and misses....doh!");
        }else{
            System.out.println(this.getName() + " hits  " + opponent.getName() + " with a sneaky blast for " + totalDamage + " damage");

            //actually cause the damage to the opponent
            opponent.takeDamage(totalDamage);
        }

    }
}
