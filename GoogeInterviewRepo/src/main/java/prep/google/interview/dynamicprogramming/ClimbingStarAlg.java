package prep.google.interview.dynamicprogramming;

public class ClimbingStarAlg {

    /**
     * Time Complexity: O(2n) , because at each stair there are two choices and there are total of n stairs.
     * Auxiliary Space: O(n), because of recursive stack space.
     * @param n
     * @return
     */
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s) { return fib(s + 1); }


    /**
     * Time Complexity: O(n)
     * Auxiliary Space: O(n)
     *
     * Climbing Stairs using Dynamic Programming (Tabulation):
     * Create a table dp[] in bottom up manner using the following relation:
     *
     * dp[i] = dp[i-1] + dp[i-2]
     *
     *
     * Follow the below steps to Implement the idea:
     *
     * Create a 1D dp where dp[i] represent the number of ways to reach the ith stair from the bottom.
     * Initialise dp[0] = 1, as there is only one way for n = 0 and dp[1] = 2 as there are only 2 ways for input n = 2.
     * Now for each i >= 2, dp[i] = dp[i-1]+dp[i-2]
     */

    // A function to find number of ways to reach the nth
    // stair
    static int countWaysUsingDP(int n)
    {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    /* Driver program to test above function */
    public static void main(String args[])
    {
        int s = 4;
        System.out.println("Number of ways = "
                + countWays(s));
    }

}
