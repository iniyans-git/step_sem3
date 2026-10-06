// Week 7 Assignment - Problem 1: The Health Bar
// Demonstrates encapsulation: private health, clamped between 0 and maxHealth

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // starts at full health
    }

    public void takeDamage(int amount) {
        health = Math.max(0, health - amount);
        System.out.println("After takeDamage(" + amount + ") -> health = " + health);
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
        System.out.println("After heal(" + amount + ") -> health = " + health);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);  // health = 70
        c.heal(50);        // health = 100 (capped at maxHealth)
        c.takeDamage(150); // health = 0 (floored at 0)
    }
}
