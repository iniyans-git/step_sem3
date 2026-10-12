// Week 10 Practice - Problem 6: Prime Number Checker
// Determines whether a number greater than 1 is prime.

import java.util.Scanner;

public class PrimeNumberChecker {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void check(int n) {
        if (isPrime(n)) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            while (sc.hasNextInt()) {
                int n = sc.nextInt();
                check(n);
            }
        } else {
            check(29);
            check(21);
        }
    }
}
