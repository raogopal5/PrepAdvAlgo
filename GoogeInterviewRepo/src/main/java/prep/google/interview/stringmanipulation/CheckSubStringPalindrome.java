package prep.google.interview.stringmanipulation;

public class CheckSubStringPalindrome {

    public static boolean check(String subS)
    {
        int size = subS.length();

        // Iterating over string till midway to
        // check palindromic behavior
        for (int i = 0; i < size / 2; i++) {

            if (subS.charAt(i)
                    != subS.charAt(size - i - 1)) {

                // Non-palindromic behavior
                return false;
            }
        }

        // Palindromic behavior
        return true;
    }

    // Method 2
    // Main driver method
    public static void main(String[] args)
    {

        // Custom input string
        String str = "MALAYALAM";

        int count = 0;

        // Outer loop iterating over input string
        for (int i = 0; i < str.length(); i++) {

            // Inner loop iterating from current starting
            // character of outer loop current starting
            // character
            for (int j = i; j < str.length(); j++) {

                // Getting the substrings
                String subString = str.substring(i, j + 1);

                // Checking whether the substring is
                // palindrome
                if (check(subString)) {

                    // Increment the count only if
                    // substring is palindrome
                    count++;
                }
            }
        }

        // Print and display the number of substrings that
        // are palindromic
        System.out.println(
                "No.of palindromic substrings in the given string are "
                        + count);
    }
}
