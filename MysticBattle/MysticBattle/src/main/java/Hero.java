package main.java;

public abstract class Hero {
    private final String name;
    private int health;

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
        System.out.println(name + " получил " + damage + " урона. Здоровье: " + this.health);
    }

    public abstract void attackEnemy(Enemy enemy);

    public void attackEnemyWithMagicWord(Enemy enemy, String magicWord) {
        int damage = calculateDamage(magicWord);
        enemy.takeDamage(damage);
        System.out.println(name + " использует магическое слово '" + magicWord + "' и наносит " + damage + " урона врагу!");
    }

    private int calculateDamage(String word) {
        int baseDamage = word.length();
        int vowelBonus = countVowels(word);
        int rareBonus = countRareLetters(word);
        return Math.min(baseDamage + vowelBonus + rareBonus, 50);
    }

    private int countVowels(String word) {
        int count = 0;
        String vowels = "аеёиоуыэюя";
        for (char c : word.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) count++;
        }
        return count * 2;
    }

    private int countRareLetters(String word) {
        int count = 0;
        String rareLetters = "фщцчш";
        for (char c : word.toLowerCase().toCharArray()) {
            if (rareLetters.indexOf(c) != -1) count++;
        }
        return count * 3;
    }
}
