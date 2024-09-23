package main.java;

public class Mage extends Hero {
    public Mage(String name) {
        super(name, 80);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        int damage = 40;
        enemy.takeDamage(damage);
        System.out.println(getName() + " атакует врага как маг и наносит " + damage + " урона!");
    }
}
