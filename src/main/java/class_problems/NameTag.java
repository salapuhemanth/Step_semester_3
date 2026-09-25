/**
 * Problem 3: The Nickname Tag
 * Category C - Class Practice Problem 3
 *
 * An immutable NameTag that generates and stores a nickname from the full name.
 */
public class NameTag {
    private final String firstName;
    private final String lastName;
    private final String nickname;

    public NameTag(String fullName) {
        if (fullName == null || !fullName.contains(" ")) {
            throw new IllegalArgumentException("Full name must contain first and last name separated by a space.");
        }
        String[] parts = fullName.trim().split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
        this.nickname = this.firstName + " " + this.lastName.charAt(0) + ".";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> \"" + tag.getNickname() + "\""); // Expected: "Maria G."
    }
}