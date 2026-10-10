import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5: Home Appliance Energy Report
 * Category C - Assignment Problem 5
 *
 * Models home appliance energy usage through an abstract base class and a SaverModeCapable interface
 * that grants 25% energy consumption discounts.
 */
public class HomeApplianceEnergyReport {

    public interface SaverModeCapable {}

    public abstract static class Appliance {
        protected String name;
        protected double hours;
        protected boolean saverMode;

        public Appliance(String name, double hours, boolean saverMode) {
            this.name = name;
            this.hours = hours;
            this.saverMode = saverMode;
        }

        public String getName() {
            return name;
        }

        public abstract double getPowerWatts();

        public boolean isSaverModeSupported() {
            return this instanceof SaverModeCapable;
        }

        public Double calculateUnits() {
            if (saverMode && !isSaverModeSupported()) {
                return null;
            }
            double units = (getPowerWatts() * hours) / 1000.0;
            if (saverMode) {
                units *= 0.75;
            }
            return units;
        }

        public Double calculateCost() {
            Double units = calculateUnits();
            return (units == null) ? null : units * 8.0;
        }
    }

    public static class Fridge extends Appliance {
        public Fridge(double hours, boolean saverMode) {
            super("FRIDGE", hours, saverMode);
        }

        @Override
        public double getPowerWatts() {
            return 150.0;
        }
    }

    public static class AirConditioner extends Appliance implements SaverModeCapable {
        public AirConditioner(double hours, boolean saverMode) {
            super("AC", hours, saverMode);
        }

        @Override
        public double getPowerWatts() {
            return 1500.0;
        }
    }

    public static class Television extends Appliance {
        public Television(double hours, boolean saverMode) {
            super("TV", hours, saverMode);
        }

        @Override
        public double getPowerWatts() {
            return 100.0;
        }
    }

    public static class WashingMachine extends Appliance implements SaverModeCapable {
        public WashingMachine(double hours, boolean saverMode) {
            super("WASHER", hours, saverMode);
        }

        @Override
        public double getPowerWatts() {
            return 500.0;
        }
    }

    public static void main(String[] args) {
        List<Appliance> appliances = new ArrayList<>();
        appliances.add(new Fridge(24, false));
        appliances.add(new AirConditioner(8, true));
        appliances.add(new Television(5, false));
        appliances.add(new WashingMachine(2, true));

        double totalCost = 0.0;
        for (Appliance a : appliances) {
            Double units = a.calculateUnits();
            Double cost = a.calculateCost();
            if (units == null || cost == null) {
                System.out.println(a.getName() + ": saver mode not supported");
            } else {
                totalCost += cost;
                System.out.println(String.format("%s: Units=%.2f Cost=%.2f", a.getName(), units, cost));
            }
        }
        System.out.println(String.format("Total Cost: %.2f", totalCost));
    }
}