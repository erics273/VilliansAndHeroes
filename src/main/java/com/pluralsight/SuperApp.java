package com.pluralsight;

public class SuperApp {

    public static void main(String[] args) {

        //create 2 SuperPeople
        SuperPerson superAbraham = new SuperPerson("Abraham", 100);
        SuperHero superAssia = new SuperHero("Assia", 100, 25);

        //ask eachSuperPerson how they are doing
        System.out.println((superAbraham.getStatus()));
        System.out.println((superAssia.getStatus()));


        //take damage
        superAbraham.takeDamage(15);
        superAssia.takeDamage(20);

        //ask eachSuperPerson how they are doing
        System.out.println(superAbraham.getStatus());
        System.out.println(superAssia.getStatus());

        //make the superfolks fight each other
        superAbraham.fight(superAssia);
        superAssia.fight(superAbraham);

        //ask eachSuperPerson how they are doing
        System.out.println(superAbraham.getStatus());
        System.out.println(superAssia.getStatus());

    }

}
