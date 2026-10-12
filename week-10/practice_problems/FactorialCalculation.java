// Week 10 Practice - Problem 7: Factorial Calculation
// Calculates the factorial of a non-negative integer.

import java.util.Scanner;

public class FactorialCalculation {
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            while (sc.hasNextInt()) {
                int n = sc.nextInt();
                System.out.println(factorial(n));
            }
        } else {
            System.out.println(factorial(5));
            System.out.println(factorial(0));
        }
    }
}
