package com.pluralsight;

import java.util.Random;

class SuperVillain extends SuperPerson {

    public SuperVillain(String name, int health, int evilness) {
        super(name, health);
        this.experiencePoints = evilness;
        System.out.println(name + " emerges with an evilness rating of " + evilness + "!");
    }

    @Override
    public void fight(SuperPerson opponent) {
        Random rand = new Random();
        int base = rand.nextInt(11);

        int bonusDamage = this.getPowerUpBonus("Crowbar");

        int damage = base + experiencePoints + bonusDamage;

        if (base == 0) {
            System.out.println(name + " fires a sneaky blast... but misses!");
        } else {
            System.out.println(name + " hits " + opponent.name + " with a sneaky blast for " + damage + " damage!");
            opponent.takeDamage(damage);
            logHit(opponent);
        }


    }

}