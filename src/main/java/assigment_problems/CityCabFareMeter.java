import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: City Cab Fare Meter
 * Category C - Assignment Problem 4
 *
 * Implements base minimum fare logic in an abstract Cab class and models night capability
 * through a dedicated NightServiceAvailable interface.
 */
public class CityCabFareMeter {

    public interface NightServiceAvailable {}

    public abstract static class Cab {
        protected String type;
        protected double km;
        protected String time;
        public static final double MINIMUM_FARE = 100.0;

        public Cab(String type, double km, String time) {
            this.type = type;
            this.km = km;
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public String getTime() {
            return time;
        }

        public abstract double getRatePerKm();

        public Double calculateFare() {
            boolean isNight = "NIGHT".equalsIgnoreCase(time);
            if (isNight && !(this instanceof NightServiceAvailable)) {
                return null; // Night service not supported
            }
            double baseFare = Math.max(MINIMUM_FARE, km * getRatePerKm());
            return isNight ? baseFare * 1.20 : baseFare;
        }
    }

    public static class MiniCab extends Cab {
        public MiniCab(double km, String time) {
            super("MINI", km, time);
        }

        @Override
        public double getRatePerKm() {
            return 10.0;
        }
    }

    public static class SedanCab extends Cab implements NightServiceAvailable {
        public SedanCab(double km, String time) {
            super("SEDAN", km, time);
        }

        @Override
        public double getRatePerKm() {
            return 14.0;
        }
    }

    public static class SUVCab extends Cab implements NightServiceAvailable {
        public SUVCab(double km, String time) {
            super("SUV", km, time);
        }

        @Override
        public double getRatePerKm() {
            return 18.0;
        }
    }

    public static void main(String[] args) {
        List<Cab> trips = new ArrayList<>();
        trips.add(new MiniCab(8, "DAY"));
        trips.add(new SedanCab(10, "NIGHT"));
        trips.add(new SUVCab(20, "DAY"));
        trips.add(new MiniCab(5, "NIGHT"));

        double grandTotal = 0.0;
        for (Cab c : trips) {
            Double fare = c.calculateFare();
            if (fare == null) {
                System.out.println(c.getType() + ": night service not available");
            } else {
                grandTotal += fare;
                System.out.println(String.format("%s: %.2f", c.getType(), fare));
            }
        }
        System.out.println(String.format("Total: %.2f", grandTotal));
    }
}