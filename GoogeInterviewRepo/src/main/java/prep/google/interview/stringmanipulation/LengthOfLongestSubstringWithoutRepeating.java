package prep.google.interview.stringmanipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * ou are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 * Time Complexity: O( N2 )
 *
 * Space Complexity: O(N) where N is the size of HashSet taken for storing the elements
 */
public class LengthOfLongestSubstringWithoutRepeating {

    static int solve(String str) {

        if(str.length()==0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) // outer loop for traversing the string
        {
            Set< Character > se = new HashSet<>();
            for (int j = i; j < str.length(); j++)
            // nested loop for getting different string starting with str[i]
            {
                if (se.contains(str.charAt(j)))
                    // if element if found so mark it as ans and break from the loop
                {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(str.charAt(j));
            }
        }
        return maxans;
    }

    public static void main(String args[]) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating characters is " + solve(str));

    }
}
