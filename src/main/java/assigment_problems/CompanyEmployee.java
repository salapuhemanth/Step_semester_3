/**
 * M5: Employee and Company Information Management
 * Category C - Assignment Problem 5
 *
 * Demonstrates static class-level memory management and counting across employee instances.
 */
public class CompanyEmployee {
    private String empName;
    private double salary;

    // Static variables shared by all instances
    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee emp1 = new CompanyEmployee("Suresh", 55000);
        CompanyEmployee emp2 = new CompanyEmployee("Meena", 60000);
        CompanyEmployee emp3 = new CompanyEmployee("David", 62000);

        System.out.println("3 Employee objects created");
        CompanyEmployee.printCompanyInfo();
    }
}