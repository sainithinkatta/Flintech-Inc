public class PalindromeCheck {
    public static void main(String[] args) {
        String original = "madam";
        String reversed = new StringBuilder(original).reverse().toString();

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);

        if (original.equalsIgnoreCase(reversed)) {
            System.out.println("Palindrome: YES");
        } else {
            System.out.println("Palindrome: NO");
        }
    }
}