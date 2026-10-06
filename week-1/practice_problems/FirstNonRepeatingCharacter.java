public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }

    public static void displayFirstNonRepeatingChar(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.printf("Input: \"%s\" -> First Non-Repeating Character: '%c'%n", text, result);
        } else {
            System.out.printf("Input: \"%s\" -> No Non-Repeating Character Found%n", text);
        }
    }

    public static void main(String[] args) {
        displayFirstNonRepeatingChar("swiss");
        displayFirstNonRepeatingChar("aabbcc");
        displayFirstNonRepeatingChar("step_sem3");
    }
}
