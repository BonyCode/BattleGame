package main.java;

public class Archer extends Hero {
    public Archer(String name) {
        super(name, 100);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        int damage = 25;
        enemy.takeDamage(damage);
        System.out.println(getName() + " атакует врага как лучник и наносит " + damage + " урона!");
    }
}

