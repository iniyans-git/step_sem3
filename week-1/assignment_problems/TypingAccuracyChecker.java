public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input");
            return;
        }

        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        String origChar = "";
        String typedChar = "";

        int minLen = Math.min(original.length(), typed.length());

        for (int i = 0; i < minLen; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1; // 1-based position
                    origChar = String.valueOf(original.charAt(i));
                    typedChar = String.valueOf(typed.charAt(i));
                }
            }
        }

        if (firstMismatchPos == -1 && original.length() != typed.length()) {
            firstMismatchPos = minLen + 1;
            origChar = original.length() > minLen ? String.valueOf(original.charAt(minLen)) : "[end]";
            typedChar = typed.length() > minLen ? String.valueOf(typed.charAt(minLen)) : "[end]";
        }

        double accuracy = total > 0 ? ((double) matched / total) * 100.0 : 0.0;

        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, total, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%s' vs '%s')%n",
                    matched, total, accuracy, firstMismatchPos, origChar, typedChar);
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
