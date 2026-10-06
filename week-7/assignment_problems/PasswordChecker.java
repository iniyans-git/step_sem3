// Week 7 Assignment - Problem 3: The Password Checker
// Demonstrates encapsulation: private final password, only strength label exposed

public class PasswordChecker {
    private final String password; // no getter — never exposed

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();
        if (len < 6) {
            return "Weak";
        } else if (len < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println(pc1.getStrength()); // Expected: Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println(pc2.getStrength()); // Expected: Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println(pc3.getStrength()); // Expected: Strong
    }
}
