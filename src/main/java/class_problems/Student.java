/**
 * M5: Student and College Information Management
 * Category C - Class Problem 5
 *
 * Demonstrates static class-level fields shared across instances and static utility methods.
 */
public class Student {
    private String name;
    private int attendance;

    // Static fields shared by all Student instances
    public static String collegeName = "SRM Institute of Science and Technology";
    public static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Kavya", 85);
        Student s2 = new Student("Rohit", 92);

        System.out.println("2 Student objects created");
        Student.printCollegeInfo();
    }
}