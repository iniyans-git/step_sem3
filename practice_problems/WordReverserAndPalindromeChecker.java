// Week 10 Practice - Problem 2: Word Reverser and Palindrome Checker
// Reverses a word using StringBuilder and checks if it's a palindrome.

import java.util.Scanner;

public class WordReverserAndPalindromeChecker {
    public static void checkWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        boolean isPalindrome = word.equalsIgnoreCase(reversed);
        if (isPalindrome) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            while (sc.hasNext()) {
                String word = sc.next();
                checkWord(word);
            }
        } else {
            checkWord("level");
            checkWord("java");
        }
    }
}
