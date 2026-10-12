// Week 10 Practice - Problem 5: Digit Sum and Number Reversal
// Calculates the sum of digits and reverses the number using modulo and division.

import java.util.Scanner;

public class DigitSumAndNumberReversal {
    public static void processNumber(int n) {
        int temp = n;
        int sum = 0;
        int reversed = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            processNumber(num);
        } else {
            processNumber(4721);
        }
    }
}
