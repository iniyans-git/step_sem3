// Week 7 Practice - Problem 3: The Nickname Tag
// Demonstrates immutability: final fields, nickname derived from constructor

public class NameTag {
    private final String firstName;
    private final String lastInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastInitial = String.valueOf(parts[1].charAt(0));
    }

    public String getNickname() {
        return firstName + " " + lastInitial + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname()); // Expected: Maria G.

        NameTag tag2 = new NameTag("Iniyan Selvam");
        System.out.println(tag2.getNickname()); // Expected: Iniyan S.
    }
}
