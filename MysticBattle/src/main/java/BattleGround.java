package main.java;

import java.util.Scanner;

public class BattleGround {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаём героев
        Hero warrior = new Warrior("Артур");
        Hero mage = new Mage("Мерлин");
        Hero archer = new Archer("Робин");

        // Создаём врагов
        Enemy orc = new Enemy("Орк", 100);
        Enemy zombie = new Zombie("Зомби", 50);

        Hero playerHero = warrior;  // Можно сменить героя на mage или archer

        System.out.println("Игра началась! Герой: " + playerHero.getName() + " против врагов: Орк и Зомби.");

        while (playerHero.getHealth() > 0 && (orc.isAlive() || zombie.isAlive())) {
            System.out.println("Выберите врага для атаки: 1 - Орк, 2 - Зомби");

            // Чтение числа с проверкой
            int enemyChoice;
            if (scanner.hasNextInt()) {
                enemyChoice = scanner.nextInt();
                scanner.nextLine(); // Очистка потока ввода после ввода числа
            } else {
                System.out.println("Неверный ввод! Пожалуйста, введите 1 или 2.");
                scanner.nextLine(); // Очистка после некорректного ввода
                continue;
            }

            if (enemyChoice == 1 || enemyChoice == 2) {
                Enemy enemyToAttack = (enemyChoice == 1) ? orc : zombie;

                System.out.println("Введите магическое слово для атаки:");
                String magicWord = scanner.nextLine(); // Считываем строку, а не одно слово

                playerHero.attackEnemyWithMagicWord(enemyToAttack, magicWord);

                if (!enemyToAttack.isAlive()) {
                    System.out.println(enemyToAttack.getClass().getSimpleName() + " побежден!");
                }

                if (orc.isAlive()) {
                    orc.attack(playerHero);
                }
                if (zombie.isAlive()) {
                    zombie.attack(playerHero);
                }

                if (playerHero.getHealth() <= 0) {
                    System.out.println("Герой пал. Игра окончена.");
                    break;
                }
            } else {
                System.out.println("Неверный ввод! Пожалуйста, введите 1 или 2.");
            }
        }

        if (playerHero.getHealth() > 0) {
            System.out.println("Вы победили всех врагов!");
        }
    }
}


