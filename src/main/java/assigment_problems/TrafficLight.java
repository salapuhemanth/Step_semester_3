/**
 * Problem 4: The Traffic Light
 * Category C - Assignment Problem 4
 *
 * Implements a state machine where color transitions can only proceed through the defined next() sequence.
 */
public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // Starts on RED
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String next() {
        if ("RED".equals(color)) {
            color = "GREEN";
        } else if ("GREEN".equals(color)) {
            color = "YELLOW";
        } else if ("YELLOW".equals(color)) {
            color = "RED";
        }
        return color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
    }
}