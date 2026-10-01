// Week 7 Practice - Problem 1: The Piggy Bank
// Demonstrates encapsulation: private savings, final id, deposit/withdraw only

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("Deposited " + amount + " -> savings = " + savings);
        } else {
            System.out.println("Deposit rejected: amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal of " + amount + " rejected, savings stays " + savings);
        } else {
            savings -= amount;
            System.out.println("Withdrew " + amount + " -> savings = " + savings);
        }
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
        System.out.println("Current savings: " + pb.getSavings());
    }
}
