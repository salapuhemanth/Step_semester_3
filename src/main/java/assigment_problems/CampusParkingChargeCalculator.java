import java.util.ArrayList;
import java.util.List;

/**
 * Problem 2: The Campus Parking Charge Calculator
 * Category C - Assignment Problem 2
 *
 * Calculates parking fee tariffs across Bike, Car, and Truck vehicle types without explicit type switching.
 */
public class CampusParkingChargeCalculator {

    public abstract static class ParkedVehicle {
        protected String vehicleType;
        protected int hours;

        public ParkedVehicle(String vehicleType, int hours) {
            this.vehicleType = vehicleType;
            this.hours = hours;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public abstract double calculateCharge();
    }

    public static class Bike extends ParkedVehicle {
        public Bike(int hours) {
            super("BIKE", hours);
        }

        @Override
        public double calculateCharge() {
            // Rs 10 per hour
            return 10.0 * hours;
        }
    }

    public static class Car extends ParkedVehicle {
        public Car(int hours) {
            super("CAR", hours);
        }

        @Override
        public double calculateCharge() {
            // Rs 30 for first hour, plus Rs 20 for each additional hour
            if (hours <= 1) {
                return 30.0;
            }
            return 30.0 + (hours - 1) * 20.0;
        }
    }

    public static class Truck extends ParkedVehicle {
        public Truck(int hours) {
            super("TRUCK", hours);
        }

        @Override
        public double calculateCharge() {
            // Rs 50 per hour, minimum charge of Rs 100
            return Math.max(100.0, 50.0 * hours);
        }
    }

    public static void main(String[] args) {
        List<ParkedVehicle> vehicles = new ArrayList<>();
        vehicles.add(new Bike(3));
        vehicles.add(new Car(4));
        vehicles.add(new Truck(1));
        vehicles.add(new Car(1));

        double grandTotal = 0.0;
        for (ParkedVehicle v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.println(String.format("%s: %.2f", v.getVehicleType(), charge));
        }
        System.out.println(String.format("Total: %.2f", grandTotal));
    }
}