import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5: The Streaming Plan Renewal Reminder
 * Category C - Assignment Problem 5
 *
 * Projects recurring subscription expiry dates handling calendar irregularities and leap years.
 */
public class StreamingPlanRenewalReminder {

    public abstract static class SubscriptionPlan {
        protected String planType;
        protected String subscriberName;
        protected LocalDate startDate;

        public SubscriptionPlan(String planType, String subscriberName, LocalDate startDate) {
            this.planType = planType;
            this.subscriberName = subscriberName;
            this.startDate = startDate;
        }

        public String getSubscriberName() {
            return subscriberName;
        }

        public abstract int getValidityDays();

        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }

    public static class BasicPlan extends SubscriptionPlan {
        public BasicPlan(String subscriberName, LocalDate startDate) {
            super("BASIC", subscriberName, startDate);
        }

        @Override
        public int getValidityDays() {
            return 30;
        }
    }

    public static class StandardPlan extends SubscriptionPlan {
        public StandardPlan(String subscriberName, LocalDate startDate) {
            super("STANDARD", subscriberName, startDate);
        }

        @Override
        public int getValidityDays() {
            return 90;
        }
    }

    public static class PremiumPlan extends SubscriptionPlan {
        public PremiumPlan(String subscriberName, LocalDate startDate) {
            super("PREMIUM", subscriberName, startDate);
        }

        @Override
        public int getValidityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {
        List<SubscriptionPlan> subscriptions = new ArrayList<>();
        subscriptions.add(new BasicPlan("Asha", LocalDate.of(2024, 1, 15)));
        subscriptions.add(new StandardPlan("Ravi", LocalDate.of(2024, 2, 1)));
        subscriptions.add(new PremiumPlan("Neha", LocalDate.of(2024, 3, 10)));
        subscriptions.add(new BasicPlan("Kiran", LocalDate.of(2024, 12, 20)));

        for (SubscriptionPlan sub : subscriptions) {
            System.out.println(sub.getSubscriberName() + ": " + sub.calculateRenewalDate());
        }
    }
}