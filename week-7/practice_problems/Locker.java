// Week 7 Practice - Problem 4: The Locker Code
// Demonstrates write-only field: private combination, no getter, changeCode() requires old code

public class Locker {
    private final int lockerNumber;
    private String combination; // write-only: no getter

    public Locker(int lockerNumber, String initialCombination) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCombination;
    }

    public void changeCode(String currentCode, String newCode) {
        if (combination.equals(currentCode)) {
            combination = newCode;
            System.out.println("Locker " + lockerNumber + ": Code changed successfully.");
        } else {
            System.out.println("Locker " + lockerNumber + ": Code change rejected, wrong current code.");
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678"); // success
        l.changeCode("0000", "9999"); // rejected, code stays "5678"
        l.changeCode("5678", "0000"); // success, verifies "5678" was set
    }
}
