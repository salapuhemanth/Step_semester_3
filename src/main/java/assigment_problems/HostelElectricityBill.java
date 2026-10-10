import java.util.ArrayList;
import java.util.List;

/**
 * Problem 3: The Hostel Electricity Bill
 * Category C - Assignment Problem 3
 *
 * Computes individual room energy utility billing polymorphically for Single, Shared, and AC rooms.
 */
public class HostelElectricityBill {

    public abstract static class RoomBill {
        protected String roomType;
        protected int units;

        public RoomBill(String roomType, int units) {
            this.roomType = roomType;
            this.units = units;
        }

        public String getRoomType() {
            return roomType;
        }

        public abstract double calculateBill();
    }

    public static class SingleRoomBill extends RoomBill {
        public SingleRoomBill(int units) {
            super("SINGLE", units);
        }

        @Override
        public double calculateBill() {
            // Rs 8 per unit
            return 8.0 * units;
        }
    }

    public static class SharedRoomBill extends RoomBill {
        private int occupants;

        public SharedRoomBill(int units, int occupants) {
            super("SHARED", units);
            this.occupants = occupants;
        }

        @Override
        public double calculateBill() {
            // Rs 6 per unit, divided equally by number of occupants
            return (6.0 * units) / occupants;
        }
    }

    public static class ACRoomBill extends RoomBill {
        public ACRoomBill(int units) {
            super("AC", units);
        }

        @Override
        public double calculateBill() {
            // Rs 10 per unit, plus a fixed charge of Rs 200
            return (10.0 * units) + 200.0;
        }
    }

    public static void main(String[] args) {
        List<RoomBill> rooms = new ArrayList<>();
        rooms.add(new SingleRoomBill(120));
        rooms.add(new SharedRoomBill(150, 3));
        rooms.add(new ACRoomBill(100));

        double grandTotal = 0.0;
        for (RoomBill r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.println(String.format("%s: %.2f", r.getRoomType(), bill));
        }
        System.out.println(String.format("Total: %.2f", grandTotal));
    }
}