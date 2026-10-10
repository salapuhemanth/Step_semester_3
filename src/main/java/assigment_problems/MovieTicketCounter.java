import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: Movie Ticket Counter
 * Category C - Assignment Problem 1
 *
 * Uses an abstract Ticket base class enforcing seat-specific prices while centralizing
 * the convenience fee calculation across Regular, Premium, and Recliner seats.
 */
public class MovieTicketCounter {

    public abstract static class Ticket {
        protected String seatType;
        protected int count;
        public static final double CONVENIENCE_FEE = 20.0; // Centralized convenience fee

        public Ticket(String seatType, int count) {
            this.seatType = seatType;
            this.count = count;
        }

        public String getSeatType() {
            return seatType;
        }

        public abstract double getBasePricePerTicket();

        public double calculateAmount() {
            return count * (getBasePricePerTicket() + CONVENIENCE_FEE);
        }
    }

    public static class RegularTicket extends Ticket {
        public RegularTicket(int count) {
            super("REGULAR", count);
        }

        @Override
        public double getBasePricePerTicket() {
            return 150.0;
        }
    }

    public static class PremiumTicket extends Ticket {
        public PremiumTicket(int count) {
            super("PREMIUM", count);
        }

        @Override
        public double getBasePricePerTicket() {
            return 250.0;
        }
    }

    public static class ReclinerTicket extends Ticket {
        public ReclinerTicket(int count) {
            super("RECLINER", count);
        }

        @Override
        public double getBasePricePerTicket() {
            return 400.0;
        }
    }

    public static void main(String[] args) {
        List<Ticket> bookings = new ArrayList<>();
        bookings.add(new RegularTicket(3));
        bookings.add(new PremiumTicket(2));
        bookings.add(new ReclinerTicket(1));

        double grandTotal = 0.0;
        for (Ticket t : bookings) {
            double amount = t.calculateAmount();
            grandTotal += amount;
            System.out.println(String.format("%s: %.2f", t.getSeatType(), amount));
        }
        System.out.println(String.format("Total: %.2f", grandTotal));
    }
}