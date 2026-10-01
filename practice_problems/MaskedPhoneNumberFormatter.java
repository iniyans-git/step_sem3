public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append("-");
        sb.append(phone.substring(6));

        return sb.toString();
    }

    public static void main(String[] args) {
        String p1 = "9876543210";
        String p2 = "98765";
        String p3 = "98765abcde";

        System.out.printf("\"%s\" -> %s%n", p1, maskPhoneNumber(p1));
        System.out.printf("\"%s\" -> %s%n", p2, maskPhoneNumber(p2));
        System.out.printf("\"%s\" -> %s%n", p3, maskPhoneNumber(p3));
    }
}
