/**
 * Problem 1: The Health Bar
 * Category C - Assignment Problem 1
 *
 * Encapsulates game character health with min/max clamping and an immutable maxHealth boundary.
 */
public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        health = Math.max(0, health - amount);
        System.out.println("c.takeDamage(" + amount + ") -> health = " + health + (health == 0 ? " (floored)" : ""));
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        health = Math.min(maxHealth, health + amount);
        System.out.println("c.heal(" + amount + ") -> health = " + health + (health == maxHealth ? " (capped)" : ""));
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}