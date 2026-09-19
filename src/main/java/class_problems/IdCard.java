/**
 * M4: Library ID Card Management
 * Category C - Class Problem 4
 *
 * Demonstrates Java object reference aliasing and equality comparisons.
 */
public class IdCard {
    public String name;
    public int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi; // Points to the exact same object in heap
        duplicate.booksIssued = 3;

        IdCard separate = new IdCard("Ravi", 3); // New separate object

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}