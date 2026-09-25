/**
 * Problem 1: The Piggy Bank
 * Category C - Class Practice Problem 1
 *
 * Encapsulates savings balance with controlled deposit/withdraw rules and an immutable ID.
 */
public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public String getId() {
        return id;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("pb.deposit(" + amount + ") -> savings = " + savings);
        }
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            return;
        }
        if (amount > savings) {
            System.out.println("pb.withdraw(" + amount + ") -> rejected, savings stays " + savings);
        } else {
            savings -= amount;
            System.out.println("pb.withdraw(" + amount + ") -> savings = " + savings);
        }
    }

    public int getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}