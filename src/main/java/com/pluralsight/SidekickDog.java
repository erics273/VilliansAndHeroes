package com.pluralsight;

public class SidekickDog implements Fightable {
    //add some properties to our sidekick dog
    private String name;
    private int health;
    private int barkPower;

    public SidekickDog(String name, int health, int barkPower) {
        this.name = name;
        this.health = health;
        this.barkPower = barkPower;
    }


    public boolean isAlive(){
        return health > 0;
    }

    public String getStatus(){

        //build and return a string that tells us how the SuperPerson is doing
        return this.name + " (SidekickDog) has " + this.health + " health left!";

    }

    @Override
    public void fight(SuperPerson opponent){
        System.out.println("The Sidekick dog howls at the moon!");
        opponent.takeDamage(this.barkPower);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBarkPower() {
        return barkPower;
    }

    public void setBarkPower(int barkPower) {
        this.barkPower = barkPower;
    }



}
