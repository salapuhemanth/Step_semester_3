import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: Payment System Fee Calculation
 * Category C - Class Practice Problem 1
 *
 * Models diverse payment channels via polymorphism, calculating fees and grand totals uniformly.
 */
public class PaymentFeeCalculator {

    public abstract static class Payment {
        protected String type;
        protected double amount;

        public Payment(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public abstract double calculateFinalAmount();
    }

    public static class CardPayment extends Payment {
        public CardPayment(double amount) {
            super("CARD", amount);
        }

        @Override
        public double calculateFinalAmount() {
            // 2% processing fee
            return amount * 1.02;
        }
    }

    public static class WalletPayment extends Payment {
        public WalletPayment(double amount) {
            super("WALLET", amount);
        }

        @Override
        public double calculateFinalAmount() {
            // 1% processing fee
            return amount * 1.01;
        }
    }

    public static class BankTransferPayment extends Payment {
        public BankTransferPayment(double amount) {
            super("BANKTRANSFER", amount);
        }

        @Override
        public double calculateFinalAmount() {
            // 0% processing fee
            return amount;
        }
    }

    public static void main(String[] args) {
        List<Payment> transactions = new ArrayList<>();
        transactions.add(new CardPayment(1000));
        transactions.add(new WalletPayment(500));
        transactions.add(new BankTransferPayment(2000));

        double grandTotal = 0.0;
        for (Payment p : transactions) {
            double finalAmount = p.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.println(String.format("%s: %.2f", p.getType(), finalAmount));
        }
        System.out.println(String.format("Total: %.2f", grandTotal));
    }
}