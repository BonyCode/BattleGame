package main.java;

public class Zombie extends Enemy {
    public Zombie(String name, int health) {
        super(name, health);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isAlive() && Math.random() < 0.5) {
            System.out.println("Зомби воскресает!");
            this.setHealth(50); // Восстанавливаем здоровье до 50
        }
    }
}

