package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    @Test
    void testWarriorAttack() {
        Hero warrior = new Warrior("Артур");
        Enemy orc = new Enemy("Орк", 100);
        warrior.attackEnemy(orc);
        assertEquals(70, orc.getHealth());
    }

    @Test
    void testMageAttack() {
        Hero mage = new Mage("Мерлин");
        Enemy zombie = new Zombie("Зомби", 50);
        mage.attackEnemy(zombie);
        assertEquals(10, zombie.getHealth());
    }

    @Test
    void testArcherAttack() {
        Hero archer = new Archer("Робин");
        Enemy orc = new Enemy("Орк", 100);
        archer.attackEnemy(orc);
        assertEquals(75, orc.getHealth());
    }
}
