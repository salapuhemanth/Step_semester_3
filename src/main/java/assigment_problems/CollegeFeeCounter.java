import java.util.ArrayList;
import java.util.List;

/**
 * Problem 3: College Fee Counter
 * Category C - Assignment Problem 3
 *
 * Models diverse student categories with an abstract Student class and an optional BusUser interface
 * to maintain common transport fees in a single place.
 */
public class CollegeFeeCounter {

    public interface BusUser {
        double TRANSPORT_FEE = 12000.0; // Centralized transport fee
        default double getTransportFee() {
            return TRANSPORT_FEE;
        }
    }

    public abstract static class Student {
        protected String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract double getTuitionFee();

        public double calculateTotalFee() {
            double total = getTuitionFee();
            if (this instanceof BusUser) {
                total += ((BusUser) this).getTransportFee();
            }
            return total;
        }
    }

    public static class DayScholar extends Student implements BusUser {
        public DayScholar(String name) {
            super(name);
        }

        @Override
        public double getTuitionFee() {
            return 40000.0;
        }
    }

    public static class Hosteller extends Student {
        public Hosteller(String name) {
            super(name);
        }

        @Override
        public double getTuitionFee() {
            // Tuition 40000 plus hostel fee 60000
            return 40000.0 + 60000.0;
        }
    }

    public static class ScholarshipStudent extends Student implements BusUser {
        public ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        public double getTuitionFee() {
            // Half of normal tuition (20000)
            return 20000.0;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new DayScholar("Asha"));
        students.add(new Hosteller("Ravi"));
        students.add(new ScholarshipStudent("Neha"));

        double grandTotal = 0.0;
        for (Student s : students) {
            double fee = s.calculateTotalFee();
            grandTotal += fee;
            System.out.println(String.format("%s: %.2f", s.getName(), fee));
        }
        System.out.println(String.format("Total Collected: %.2f", grandTotal));
    }
}