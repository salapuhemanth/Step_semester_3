import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5: Public Transport Fare Calculator
 * Category C - Class Practice Problem 5
 *
 * Calculates transport commuter charges across Bus, Train, and Metro modes using polymorphism.
 */
public class TransportFareCalculator {

    public abstract static class TransportJourney {
        protected String type;
        protected double distance;

        public TransportJourney(String type, double distance) {
            this.type = type;
            this.distance = distance;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateFare();
    }

    public static class BusJourney extends TransportJourney {
        public BusJourney(double distance) {
            super("BUS", distance);
        }

        @Override
        public double calculateFare() {
            // Base fare $2, plus $0.10 per km. Max fare $10.
            double fare = 2.0 + (0.10 * distance);
            return Math.min(10.0, fare);
        }
    }

    public static class TrainJourney extends TransportJourney {
        public TrainJourney(double distance) {
            super("TRAIN", distance);
        }

        @Override
        public double calculateFare() {
            // Base fare $3, plus $0.15 per km.
            return 3.0 + (0.15 * distance);
        }
    }

    public static class MetroJourney extends TransportJourney {
        private double peakHourFactor;

        public MetroJourney(double distance, double peakHourFactor) {
            super("METRO", distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        public double calculateFare() {
            // Base fare $1.50, plus $0.20 per km, multiplied by PeakHourFactor.
            return (1.50 + (0.20 * distance)) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        List<TransportJourney> journeys = new ArrayList<>();
        journeys.add(new BusJourney(15));
        journeys.add(new TrainJourney(50));
        journeys.add(new MetroJourney(10, 1.5));

        double grandTotal = 0.0;
        for (TransportJourney j : journeys) {
            double fare = j.calculateFare();
            grandTotal += fare;
            System.out.println(String.format("%s: %.2f", j.getType(), fare));
        }
        System.out.println(String.format("Total: %.2f", grandTotal));
    }
}