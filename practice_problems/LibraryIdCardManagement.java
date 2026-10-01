// Week 6 Practice - M4: Library ID Card Management
// Demonstrates object references and == comparison

public class LibraryIdCardManagement {

    static class IdCard {
        String name;
        int booksIssued;

        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);

        // Second variable points to the SAME object (no new object created)
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Third, SEPARATE object with identical field values
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
