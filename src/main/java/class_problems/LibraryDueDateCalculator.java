import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 2: Library Item Due Date Calculator
 * Category C - Class Practice Problem 2
 *
 * Polymorphic library catalog calculating item due dates based on specific borrowing policies.
 */
public class LibraryDueDateCalculator {

    public abstract static class LibraryItem {
        protected String title;
        protected static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

        public LibraryItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public abstract int getBorrowPeriodDays();

        public LocalDate calculateDueDate() {
            return CURRENT_DATE.plusDays(getBorrowPeriodDays());
        }
    }

    public static class BookItem extends LibraryItem {
        public BookItem(String title) {
            super(title);
        }

        @Override
        public int getBorrowPeriodDays() {
            return 14;
        }
    }

    public static class DVDItem extends LibraryItem {
        public DVDItem(String title) {
            super(title);
        }

        @Override
        public int getBorrowPeriodDays() {
            return 7;
        }
    }

    public static class MagazineItem extends LibraryItem {
        public MagazineItem(String title) {
            super(title);
        }

        @Override
        public int getBorrowPeriodDays() {
            return 3;
        }
    }

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new BookItem("1984"));
        items.add(new DVDItem("The Matrix"));
        items.add(new MagazineItem("Forbes Issue 500"));

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate());
        }
    }
}