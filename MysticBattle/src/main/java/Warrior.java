package main.java;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name, 120);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        int damage = 30;
        enemy.takeDamage(damage);
        System.out.println(getName() + " атакует врага как воин и наносит " + damage + " урона!");
    }
}
