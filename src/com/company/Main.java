package com.company;
import java.util.Random;
public class Main {

        public static int roundNumber = 1;


        public static int bossHealth = 1000;
        public static int bossDamage = 60;
        public static String bossDefence = "";

        public static String[] heroesType = {"Psyhikal", "Magical", "Kinetik", "Healer"};
        public static int[] heroesHealth = {300, 350, 280,250};
        public static int[] heroesDamage = {50, 60, 50, 0};

        public static void main(String[] args) {
            printStatistic();
            while (isGameFinished()) {
                round();
            }
        }

        public static void HealerHeal() {
            for (int i = 0; i < heroesHealth.length; i++) {
                if (1 == 3) {
                    continue;
                }
                if (heroesHealth[i] > 0 && heroesHealth[i] < 100 && heroesHealth[i] > 0) {
                    heroesHealth[i] += 40;
                    System.out.println("Medic help: " + heroesType[i]);
                    break;
                }
            }
        }


        public static void round() {
            roundNumber++;
            chooseBossDefence();
            bossHit();
            heroesHit();
            printStatistic();
            HealerHeal();
        }

        public static void printStatistic() {
            System.out.println("Round: " + roundNumber + " Statistic:");
            System.out.println("---------------------");
            System.out.println("Boss health: " +
                    bossHealth + "; Boss damage: " + bossDamage);
            for (int i = 0; i < heroesHealth.length; i++) {
                System.out.println(heroesType[i] + " Health: "
                        + heroesHealth[i]);
                System.out.println(heroesType[i] + " Damage: " + heroesDamage[i]);
            }
            System.out.println("---------------------");
        }


        public static void chooseBossDefence() {
            Random random = new Random();
            int randomIndex = random.nextInt(heroesType.length);
            bossDefence = heroesType[randomIndex];
            System.out.println("Bosse have defence " + bossDefence);
        }


        public static void bossHit() {
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesHealth[i] > 0) {
                    if (heroesHealth[i] - bossDamage < 0) {
                        heroesHealth[i] = 0;
                    } else {
                        heroesHealth[i] = heroesHealth[i] - bossDamage;
                    }
                }
            }
        }

        public static void heroesHit() {
            for (int i = 0; i < heroesDamage.length; i++) {
                if (heroesHealth[i] > 0 && bossHealth > 0) {
                    if (heroesType[i] == bossDefence) {
                        Random random = new Random();
                        int coeff = random.nextInt(10);
                        if (bossHealth - heroesDamage[i] * coeff < 0) {

                            bossHealth = 0;

                        } else {
                            bossHealth = bossHealth - heroesDamage[i] * coeff;
                        }
                        System.out.println(heroesType[i] + " Critical damage "
                                + heroesDamage[i] * coeff);
                    } else {

                        if (bossHealth - heroesDamage[i] < 0) {
                            bossHealth = 0;
                        } else {
                            bossHealth = bossHealth - heroesDamage[i];
                        }
                    }
                }
            }
        }


        public static boolean isGameFinished() {
            if (bossHealth <= 0) {
                System.out.println("Heroes won!!!");
                return false;
            }
            boolean allHeroesDead = true;
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesHealth[i] > 0) {
                    allHeroesDead = false;
                    break;
                }
            }
            if (allHeroesDead) {
                System.out.println("Boss won!!!");
            }
            return !allHeroesDead;
        }
    }