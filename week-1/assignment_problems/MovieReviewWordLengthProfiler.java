public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split on whitespace
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;   // 1–4 letters
        int mediumCount = 0;  // 5–8 letters
        int longCount = 0;    // 9+ letters

        for (String word : words) {
            // Strip any surrounding punctuation to isolate word letters
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
            int len = cleanWord.length();
            if (len == 0) continue;

            if (len <= 4) {
                shortCount++;
            } else if (len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        System.out.println("Review: \"" + review + "\"");
        classifyWordLengths(review);
    }
}
