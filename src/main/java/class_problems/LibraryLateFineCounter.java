import java.util.ArrayList;
import java.util.List;

/**
 * Problem 3: Library Late Fine Counter
 * Category C - Class Practice Problem 3
 *
 * Defines an abstract LibraryItem base class mandating overdue fine computation across
 * Books, DVDs, and Magazines.
 */
public class LibraryLateFineCounter {

    public abstract static class LibraryItem {
        protected String title;
        protected int daysLate;

        public LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        public String getTitle() {
            return title;
        }

        public abstract double calculateFine();
    }

    public static class Book extends LibraryItem {
        public Book(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return 2.0 * daysLate;
        }
    }

    public static class DVD extends LibraryItem {
        public DVD(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return Math.min(50.0, 5.0 * daysLate);
        }
    }

    public static class Magazine extends LibraryItem {
        public Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        public double calculateFine() {
            return 1.0 * daysLate;
        }
    }

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("Algebra", 4));
        items.add(new DVD("Inception", 12));
        items.add(new Magazine("Sports", 3));

        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.println(String.format("%s: %.2f", item.getTitle(), fine));
        }
        System.out.println(String.format("Total Fines: %.2f", totalFines));
    }
}