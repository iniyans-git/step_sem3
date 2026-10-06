public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return checkRecursive(text, 0, text.length() - 1);
    }

    private static boolean checkRecursive(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return checkRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void test(String word) {
        boolean it = isPalindromeIterative(word);
        boolean rec = isPalindromeRecursive(word);
        boolean rev = isPalindromeArrayReversal(word);

        System.out.printf("\"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                word,
                it ? "Palindrome" : "Not Palindrome",
                rec ? "Palindrome" : "Not Palindrome",
                rev ? "Palindrome" : "Not Palindrome");
    }

    public static void main(String[] args) {
        test("madam");
        test("hello");
        test("racecar");
    }
}
