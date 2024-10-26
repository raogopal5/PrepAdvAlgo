package prep.google.interview.backtracking;


import java.util.*;

/**Given a binary pattern containing ? wildcard character at a few positions,
 * find all possible combinations of binary strings that can be formed by replacing the wildcard character by either 0 or 1.

 For example, for wildcard pattern 1?11?00?1?, the possible combinations are:

 101100001010110000111011000110101100011110111000101011100011101110011010111001
 1111110000101111000011111100011011110001111111100010111110001111111001101111100111
 *
 */
public class BinaryStringFromWildCardPattern {

    // Find all combinations of non-overlapping substrings of a given string
    public static void findCombinations(String str, Deque<String> substring,
                                        Set<List<String>> combinations)
    {
        // if all characters of the input string are processed,
        // add the output string to result
        if (str.length() == 0) {
            combinations.add(new ArrayList<>(substring));
            return;
        }

        // add each substring `str[0, i]` to the output string and recur for
        // remaining substring `str[i+1, n-1]`
        for (int i = 0; i < str.length(); i++)
        {
            // push substring `str[0, i]` into the output string
            substring.addLast(str.substring(0, i + 1));

            // recur for the remaining string `str[i+1, n-1]`
            findCombinations(str.substring(i + 1), substring, combinations);

            // backtrack: remove current substring from the output
            substring.pollLast();
        }
    }

    public static Set<List<String>> findCombinations(String s)
    {
        Set<List<String>> combinations = new HashSet<>();

        // base case
        if (s == null || s.length() == 0) {
            return combinations;
        }

        // string to store non-overlapping substrings
        Deque<String> substring = new ArrayDeque<>();

        // find all non-overlapping substrings
        findCombinations(s, substring, combinations);

        return combinations;
    }

    public static void main(String[] args)
    {
        // input string
        String str = "ABCD";

        // find all non-overlapping substrings
        Set<List<String>> combinations = findCombinations(str);
        System.out.println(combinations);
    }
}
