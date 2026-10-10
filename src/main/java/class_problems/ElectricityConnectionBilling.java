import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: Electricity Connection Billing
 * Category C - Class Practice Problem 4
 *
 * Implements an abstract connection hierarchy modeling tiered consumption calculations
 * for Home, Shop, and Factory consumers.
 */
public class ElectricityConnectionBilling {

    public abstract static class Connection {
        protected String type;
        protected int units;

        public Connection(String type, int units) {
            this.type = type;
            this.units = units;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateBill();
    }

    public static class HomeConnection extends Connection {
        public HomeConnection(int units) {
            super("HOME", units);
        }

        @Override
        public double calculateBill() {
            if (units <= 100) {
                return 5.0 * units;
            } else {
                return (100 * 5.0) + ((units - 100) * 7.0);
            }
        }
    }

    public static class ShopConnection extends Connection {
        public ShopConnection(int units) {
            super("SHOP", units);
        }

        @Override
        public double calculateBill() {
            return (8.0 * units) + 100.0;
        }
    }

    public static class FactoryConnection extends Connection {
        public FactoryConnection(int units) {
            super("FACTORY", units);
        }

        @Override
        public double calculateBill() {
            return Math.max(1000.0, 6.0 * units);
        }
    }

    public static void main(String[] args) {
        List<Connection> connections = new ArrayList<>();
        connections.add(new HomeConnection(150));
        connections.add(new ShopConnection(90));
        connections.add(new FactoryConnection(120));

        double grandTotal = 0.0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            grandTotal += bill;
            System.out.println(String.format("%s: %.2f", c.getType(), bill));
        }
        System.out.println(String.format("Total: %.2f", grandTotal));
    }
}