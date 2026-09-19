/**
 * M4: Exam Hall Ticket Reference Management
 * Category C - Assignment Problem 4
 *
 * Proves object reference sharing vs distinct object instantiation using the == equality operator.
 */
public class HallTicket {
    public String studentName;
    public int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya; // Points to identical memory address
        copy.seatNumber = 45;

        HallTicket separate = new HallTicket("Priya", 45); // Distinct instance

        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}