import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5: Travel Booking with a Common Fee
 * Category C - Class Practice Problem 5
 *
 * Utilizes the template method pattern in an abstract TravelBooking base class to maintain
 * a centralized single-point booking fee across Bus, Train, and Flight transit.
 */
public class TravelBookingCommonFee {

    public abstract static class TravelBooking {
        protected String mode;
        protected double distanceKm;
        public static final double BOOKING_FEE = 50.0; // Centralized in one place

        public TravelBooking(String mode, double distanceKm) {
            this.mode = mode;
            this.distanceKm = distanceKm;
        }

        public String getMode() {
            return mode;
        }

        public abstract double getBaseFare();

        public double calculateTotal() {
            return getBaseFare() + BOOKING_FEE;
        }
    }

    public static class BusBooking extends TravelBooking {
        public BusBooking(double distanceKm) {
            super("BUS", distanceKm);
        }

        @Override
        public double getBaseFare() {
            return 2.0 * distanceKm;
        }
    }

    public static class TrainBooking extends TravelBooking {
        public TrainBooking(double distanceKm) {
            super("TRAIN", distanceKm);
        }

        @Override
        public double getBaseFare() {
            return 1.5 * distanceKm;
        }
    }

    public static class FlightBooking extends TravelBooking {
        public FlightBooking(double distanceKm) {
            super("FLIGHT", distanceKm);
        }

        @Override
        public double getBaseFare() {
            return 2500.0 + (4.0 * distanceKm);
        }
    }

    public static void main(String[] args) {
        List<TravelBooking> bookings = new ArrayList<>();
        bookings.add(new BusBooking(200));
        bookings.add(new TrainBooking(300));
        bookings.add(new FlightBooking(500));

        for (TravelBooking b : bookings) {
            System.out.println(String.format("%s: %.2f", b.getMode(), b.calculateTotal()));
        }
    }
}