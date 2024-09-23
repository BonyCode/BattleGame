package main.java;

import java.util.Random;

public class Enemy implements Mortal {
    private int health;
    private String name;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
        System.out.println(name + " получил " + damage + " урона. Здоровье: " + this.health);
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    public void attack(Hero hero) {
        Random rand = new Random();
        int damage = rand.nextInt(10) + 1; // Враг наносит случайный урон от 1 до 10
        hero.takeDamage(damage);
        System.out.println(name + " атакует героя и наносит " + damage + " урона!");
    }
}

