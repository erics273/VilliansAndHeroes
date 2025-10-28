package com.pluralsight;

public class ShowdownApp {

    public static void main(String[] args) {
        SuperHero hero = new SuperHero("CodeMaster", 100, 10);
        SuperVillain villain = new SuperVillain("Nullinator", 100, 7);

        System.out.println("=== Welcome to the Super Showdown! ===");
        System.out.println(hero.getStatus());
        System.out.println(villain.getStatus());

        while (hero.isAlive() && villain.isAlive()) {
            System.out.println("\n-- Hero's Turn --");
            hero.fight(villain);
            System.out.println(villain.getStatus());

            if (!villain.isAlive()) {
                break;
            }

            System.out.println("\n-- Villain's Turn --");
            villain.fight(hero);
            System.out.println(hero.getStatus());
        }

        System.out.println("\n=== The Battle is Over! ===");

        if (hero.isAlive()) {
            System.out.println(hero.name + " wins the showdown!");
        } else {
            System.out.println(villain.name + " has defeated the hero!");
        }
    }

}
