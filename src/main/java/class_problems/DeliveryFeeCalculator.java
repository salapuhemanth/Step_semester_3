import java.util.ArrayList;
import java.util.List;

/**
 * Problem 3: Delivery Fee Calculator
 * Category C - Class Practice Problem 3
 *
 * Calculates parcel logistics charges across different courier types using polymorphic dispatch.
 */
public class DeliveryFeeCalculator {

    public abstract static class Delivery {
        protected String type;
        protected double weight;
        protected double distance;

        public Delivery(String type, double weight, double distance) {
            this.type = type;
            this.weight = weight;
            this.distance = distance;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateFee();
    }

    public static class StandardDelivery extends Delivery {
        public StandardDelivery(double weight, double distance) {
            super("STANDARD", weight, distance);
        }

        @Override
        public double calculateFee() {
            // Base fee $5, plus $0.50 per kg, plus $0.10 per km
            return 5.0 + (0.50 * weight) + (0.10 * distance);
        }
    }

    public static class ExpressDelivery extends Delivery {
        public ExpressDelivery(double weight, double distance) {
            super("EXPRESS", weight, distance);
        }

        @Override
        public double calculateFee() {
            // Base fee $20 ($5 standard base + $15 express surcharge), plus $1.00 per kg, plus $0.20 per km
            return 20.0 + (1.00 * weight) + (0.20 * distance);
        }
    }

    public static class InternationalDelivery extends Delivery {
        private double customsFee;

        public InternationalDelivery(double weight, double distance, double customsFee) {
            super("INTERNATIONAL", weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        public double calculateFee() {
            // Base fee $35 ($20 express base + $15 international surcharge), plus $2.00 per kg, plus $0.50 per km, plus CustomsFee
            return 35.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
        }
    }

    public static void main(String[] args) {
        List<Delivery> requests = new ArrayList<>();
        requests.add(new StandardDelivery(10, 50));
        requests.add(new ExpressDelivery(5, 20));
        requests.add(new InternationalDelivery(20, 100, 30));

        double grandTotal = 0.0;
        for (Delivery d : requests) {
            double fee = d.calculateFee();
            grandTotal += fee;
            System.out.println(String.format("%s: %.2f", d.getType(), fee));
        }
        System.out.println(String.format("Total: %.2f", grandTotal));
    }
}