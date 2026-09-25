/**
 * Problem 5: The Attendance Sheet
 * Category C - Class Practice Problem 5
 *
 * Stores present students internally with duplicate prevention, exposing count and lookup only.
 */
public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String name) {
        if (name == null || isPresent(name)) {
            return; // Ignore duplicates
        }
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount++] = name;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < presentCount; i++) {
            if (name.equals(presentStudents[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount()); // Expected: 2
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));     // Expected: true
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));   // Expected: false
    }
}