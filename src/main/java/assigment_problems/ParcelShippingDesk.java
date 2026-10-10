import java.util.ArrayList;
import java.util.List;

/**
 * Problem 2: Parcel Shipping Desk
 * Category C - Assignment Problem 2
 *
 * Separates shipping calculation via abstract Parcel class from optional insurance capability
 * using an Insurable interface.
 */
public class ParcelShippingDesk {

    public interface Insurable {
        double calculateInsurance();
    }

    public abstract static class Parcel {
        protected String type;
        protected double weightKg;
        protected double declaredValue;

        public Parcel(String type, double weightKg, double declaredValue) {
            this.type = type;
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateShippingCharge();
    }

    public static class StandardParcel extends Parcel {
        public StandardParcel(double weightKg, double declaredValue) {
            super("STANDARD", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 40.0 + (10.0 * weightKg);
        }
    }

    public static class ExpressParcel extends Parcel implements Insurable {
        public ExpressParcel(double weightKg, double declaredValue) {
            super("EXPRESS", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            return 80.0 + (15.0 * weightKg);
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    public static class FragileParcel extends Parcel implements Insurable {
        public FragileParcel(double weightKg, double declaredValue) {
            super("FRAGILE", weightKg, declaredValue);
        }

        @Override
        public double calculateShippingCharge() {
            // Standard charge (40 + 10 * weight) plus handling fee of 50
            return 40.0 + (10.0 * weightKg) + 50.0;
        }

        @Override
        public double calculateInsurance() {
            return 0.02 * declaredValue;
        }
    }

    public static void main(String[] args) {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add(new StandardParcel(3, 500));
        parcels.add(new ExpressParcel(2, 1000));
        parcels.add(new FragileParcel(4, 2000));

        double grandTotal = 0.0;
        for (Parcel p : parcels) {
            double charge = p.calculateShippingCharge();
            double insurance = (p instanceof Insurable) ? ((Insurable) p).calculateInsurance() : 0.0;
            double total = charge + insurance;
            grandTotal += total;

            System.out.println(String.format("%s: Charge=%.2f Insurance=%.2f Total=%.2f",
                    p.getType(), charge, insurance, total));
        }
        System.out.println(String.format("Grand Total: %.2f", grandTotal));
    }
}