package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    @Test
    void testZombieResurrection() {
        Enemy zombie = new Zombie("Зомби", 50);
        Hero mage = new Mage("Мерлин");

        // Атакуем зомби до нуля здоровья
        for (int i = 0; i < 2; i++) { // Дважды атакуем, чтобы гарантированно убить зомби
            mage.attackEnemy(zombie);
        }

        // Проверяем оба возможных исхода
        if (zombie.isAlive()) {
            assertEquals(50, zombie.getHealth(), "Зомби должен был воскреснуть с 50 здоровья");
        } else {
            assertEquals(0, zombie.getHealth(), "Зомби должен остаться мёртвым");
        }
    }

    @Test
    void testEnemyAttack() {
        Hero warrior = new Warrior("Артур");
        Enemy orc = new Enemy("Орк", 100);

        // Орк атакует воина
        orc.attack(warrior);

        // Проверка, что здоровье воина уменьшилось на величину в диапазоне от 1 до 10
        int remainingHealth = warrior.getHealth();
        assertTrue(remainingHealth <= 120 && remainingHealth >= 110, "Урон должен быть в диапазоне 1-10");
    }
}


