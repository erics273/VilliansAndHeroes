package com.pluralsight;

public class SuperApp {

    public static void main(String[] args) {

        //create our hero
        SuperHero hero = new SuperHero("CodeMaster", 100, 10);
        //create our villian
        SuperVillain villain = new SuperVillain("Nullinator", 100, 7);

        //add some power ups to hero and villian
        hero.addPowerUp("Bat", 10);
        hero.addPowerUp("Throwing Star", 20);
        hero.addPowerUp("Laser Phaser", 15);

        villain.addPowerUp("Crowbar", 5);
        villain.addPowerUp("Blow Dart", 25);
        villain.addPowerUp("BFG", 30);

        //display an introduction to the game
        System.out.println("=== Welcome to the Super Showdown! ===");

        //show the status of the hero and the villian
        System.out.println(hero.getStatus());
        System.out.println(villain.getStatus());

        //loop while both the hero and villian are still alive
        while (hero.isAlive() && villain.isAlive()) {
            //it is the heroes turn
            System.out.println("\n-- Hero's Turn --");
            //make the hero fight the villian
            hero.fight(villain);

            //how does the villian feel after being attacked by the hero
            System.out.println(villain.getStatus());

            //did we kill the villian
            //if the villian is not alive, we killed the villian and not need
            //to keep the fight going
            if (!villain.isAlive()) {
                //break exits the loop
                break;
            }

            //it is the villians turn
            System.out.println("\n-- Villain's Turn --");
            //smack the hero, villian gets an opportunity to fight the hero
            villain.fight(hero);
            //check on the hero after they got attacked by the villian
            System.out.println(hero.getStatus());
        }

        //let the world know the battle is over
        System.out.println("\n=== The Battle is Over! ===");

        //determine a winner
        if (hero.isAlive()) {
            System.out.println(hero.name + " wins the showdown!");
        } else {
            System.out.println(villain.name + " has defeated the hero!");
        }

        hero.printBattleLog();
        villain.printBattleLog();

    }

}
