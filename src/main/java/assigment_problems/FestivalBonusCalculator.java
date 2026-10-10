import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: The Festival Bonus Calculator
 * Category C - Assignment Problem 4
 *
 * Evaluates festive employee compensation policies across Full-Time, Part-Time, and Intern positions.
 */
public class FestivalBonusCalculator {

    public abstract static class Employee {
        protected String type;
        protected String name;
        protected double monthlySalary;

        public Employee(String type, String name, double monthlySalary) {
            this.type = type;
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        public String getName() {
            return name;
        }

        public abstract double calculateBonus();
    }

    public static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double monthlySalary) {
            super("FULLTIME", name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            // 10% of monthly salary
            return 0.10 * monthlySalary;
        }
    }

    public static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double monthlySalary) {
            super("PARTTIME", name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            // 5% of monthly salary
            return 0.05 * monthlySalary;
        }
    }

    public static class InternEmployee extends Employee {
        public InternEmployee(String name, double monthlySalary) {
            super("INTERN", name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            // Fixed bonus of Rs 2,000
            return 2000.0;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("Asha", 50000));
        employees.add(new PartTimeEmployee("Ravi", 30000));
        employees.add(new InternEmployee("Neha", 15000));

        double grandTotal = 0.0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            grandTotal += bonus;
            System.out.println(String.format("%s: %.2f", e.getName(), bonus));
        }
        System.out.println(String.format("Total Bonus: %.2f", grandTotal));
    }
}