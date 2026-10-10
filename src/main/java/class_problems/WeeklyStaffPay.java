import java.util.ArrayList;
import java.util.List;

/**
 * Problem 2: Weekly Staff Pay
 * Category C - Class Practice Problem 2
 *
 * Employs an abstract StaffMember class preventing direct instantiation while enforcing
 * specialized payroll calculations across Full-Time, Hourly, and Intern roles.
 */
public class WeeklyStaffPay {

    public abstract static class StaffMember {
        protected String name;

        public StaffMember(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract double calculatePay();
    }

    public static class FullTimeStaff extends StaffMember {
        private double weeklySalary;

        public FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        public double calculatePay() {
            return weeklySalary;
        }
    }

    public static class HourlyStaff extends StaffMember {
        private double hours;
        private double rate;

        public HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        public double calculatePay() {
            if (hours <= 40) {
                return hours * rate;
            } else {
                return (40 * rate) + ((hours - 40) * rate * 1.5);
            }
        }
    }

    public static class InternStaff extends StaffMember {
        private double stipend;

        public InternStaff(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        public double calculatePay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        List<StaffMember> staffList = new ArrayList<>();
        staffList.add(new FullTimeStaff("Asha", 12000));
        staffList.add(new HourlyStaff("Ravi", 45, 200));
        staffList.add(new InternStaff("Neha", 5000));

        double totalPayroll = 0.0;
        for (StaffMember staff : staffList) {
            double pay = staff.calculatePay();
            totalPayroll += pay;
            System.out.println(String.format("%s: %.2f", staff.getName(), pay));
        }
        System.out.println(String.format("Total Payroll: %.2f", totalPayroll));
    }
}