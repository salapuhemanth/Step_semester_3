import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: The Canteen Billing Counter
 * Category C - Assignment Problem 1
 *
 * Models canteen patron types using polymorphism to calculate discounts, surcharges, and total receipts.
 */
public class CanteenBillingCounter {

    public abstract static class CustomerBill {
        protected String customerType;
        protected double amount;

        public CustomerBill(String customerType, double amount) {
            this.customerType = customerType;
            this.amount = amount;
        }

        public String getCustomerType() {
            return customerType;
        }

        public abstract double calculateFinalAmount();
    }

    public static class StudentBill extends CustomerBill {
        public StudentBill(double amount) {
            super("STUDENT", amount);
        }

        @Override
        public double calculateFinalAmount() {
            // 10% discount
            return amount * 0.90;
        }
    }

    public static class StaffBill extends CustomerBill {
        public StaffBill(double amount) {
            super("STAFF", amount);
        }

        @Override
        public double calculateFinalAmount() {
            // 5% discount
            return amount * 0.95;
        }
    }

    public static class GuestBill extends CustomerBill {
        public GuestBill(double amount) {
            super("GUEST", amount);
        }

        @Override
        public double calculateFinalAmount() {
            // Full amount plus Rs 10 service charge
            return amount + 10.0;
        }
    }

    public static void main(String[] args) {
        List<CustomerBill> bills = new ArrayList<>();
        bills.add(new StudentBill(200));
        bills.add(new StaffBill(300));
        bills.add(new GuestBill(150));

        double grandTotal = 0.0;
        for (CustomerBill b : bills) {
            double finalAmount = b.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.println(String.format("%s: %.2f", b.getCustomerType(), finalAmount));
        }
        System.out.println(String.format("Total: %.2f", grandTotal));
    }
}