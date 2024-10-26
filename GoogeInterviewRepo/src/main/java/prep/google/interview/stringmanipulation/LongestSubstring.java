package prep.google.interview.stringmanipulation;

public class LongestSubstring {
    // Function to print a subString str[low..high]

    /**
     * Time complexity: O(N3). Three nested loops are needed to find the longest palindromic substring in this approach.
     * Auxiliary complexity: O(1). As no extra space is needed
     * @param str
     * @param low
     * @param high
     */
    static void printSubStrUsingDP(String str, int low, int high)
    {
        for (int i = low; i <= high; ++i)
            System.out.print(str.charAt(i));
    }

    // This function prints the
    // longest palindrome subString
    // It also returns the length
    // of the longest palindrome
    static int longestPalSubstr(String str)
    {
        // Get length of input String
        int n = str.length();

        // All subStrings of length 1
        // are palindromes
        int maxLength = 1, start = 0;

        // Nested loop to mark start and end index
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k)
                            != str.charAt(j - k))
                        flag = 0;

                // Palindrome
                if (flag != 0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        System.out.print(
                "Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);

        // Return length of LPS
        return maxLength;
    }

    // A utility function to print
    // a substring str[low..high]
    static void printSubStr(
            String str, int low, int high)
    {
        System.out.println(
                str.substring(
                        low, high + 1));
    }

    // This function prints the longest
    // palindrome substring of str[].
    // It also returns the length of the
    // longest palindrome
    static int longestPalSubstrusingDP(String str)
    {
        // Get length of input string
        int n = str.length();

        // table[i][j] will be false if
        // substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        // Check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2.
        // k is length of substring
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {

                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // Checking for sub-string from ith index to
                // jth index if str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1]
                        && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is: ");
        printSubStrUsingDP(str, start, start + maxLength - 1);

        // Return length of LPS
        return maxLength;
    }



    // Driver Code
    public static void main(String[] args)
    {
        String str = "forgeeksskeegfor";
        System.out.print("\nLength is: "
                + longestPalSubstrusingDP(str));
        System.out.print("\nLength is: "
                + longestPalSubstr(str));
    }
}
