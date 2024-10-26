package prep.google.interview.backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a set S, generate all subsets of it, i.e., find the power set of set S. A power set of any set S is the set of all subsets of S, including the empty set and S itself.
 *
 * For example, if S is the set {x, y, z}, then the subsets of S are:
 *
 * {} (also known as the empty set or the null set).
 * {x}
 * {y}
 * {z}
 * {x, y}
 * {x, z}
 * {y, z}
 * {x, y, z}
 * Hence, the power set of S is {{}, {x}, {y}, {z}, {x, y}, {x, z}, {y, z}, {x, y, z}}.
 */
public class FindPowerSet {

    // Function to generate power set of a given set `S`

    public static void findPowerSet(int[] S, Deque<Integer> set, int n)
    {
        // if we have considered all elements
        if (n == 0)
        {
            System.out.println(set);
            return;
        }

        // consider the n'th element
        set.addLast(S[n - 1]);
        findPowerSet(S, set, n - 1);

        set.removeLast();                    // backtrack

        // or don't consider the n'th element
        findPowerSet(S, set, n - 1);
    }

    public static void main(String[] args)
    {
        int[] S = { 1, 2, 3 };

        Deque<Integer> set = new ArrayDeque<>();
        findPowerSet(S, set, S.length);
    }
}
