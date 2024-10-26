package prep.google.interview.dynamicprogramming;

import java.util.Arrays;

public class CoinChanges {

    // Recursive function to count the ways to make change

    /**
     * Memorization Approach
     * teps to memoize a recursive solution:
     *
     * If we draw the recursion tree, we will see that there are overlapping subproblems. In order to convert a recursive solution to the following steps will be taken:
     *
     * Create a dp array of size [n][T+1]. The size of the input array is ‘N’, so the index will always lie between ‘0’ and ‘n-1’.
     * The target can take any value between ‘0’ and ‘T’. Therefore we take the dp array as dp[n][T+1]
     * We initialize the dp array to -1.
     * Whenever we want to find the answer of particular parameters (say f(ind,target)), we first check whether the answer
     * is already calculated using the dp array(i.e dp[ind][target]!= -1 ). If yes, simply return the value from the dp array.
     * If not, then we are finding the answer for the given value for the first time, we will use the recursive relation as usual but before returning from the function, we will set dp[ind][target] to the solution we get.
     * Time Complexity: O(N*T)
     *
     * Reason: There are N*W states therefore at max ‘N*T’ new problems will be solved.
     *
     * Space Complexity: O(N*T) + O(N)
     *
     * Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*T)).
     * @param arr
     * @param ind
     * @param T
     * @param dp
     * @return
     */
    static long countWaysToMakeChangeUtil(int[] arr, int ind, int T, long[][] dp) {
        // Base case: If the current index is 0
        if (ind == 0) {
            // If T is divisible by the first element of the array, return 1, else return 0
            if (T % arr[0] == 0)
                return 1;
            else
                return 0;
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][T] != -1)
            return dp[ind][T];

        // Calculate the number of ways without taking the current element
        long notTaken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp);

        // Initialize the number of ways taking the current element as 0
        long taken = 0;

        // If the current element is less than or equal to T, calculate 'taken'
        if (arr[ind] <= T)
            taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp);

        // Store the result in the dp array and return it
        return dp[ind][T] = notTaken + taken;
    }

    // Function to count the ways to make change
    static long countWaysToMakeChange(int[] arr, int n, int T) {
        // Create a 2D array to store results of subproblems
        long dp[][] = new long[n][T + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (long row[] : dp)
            Arrays.fill(row, -1);

        // Call the countWaysToMakeChangeUtil function to calculate the number of ways
        return countWaysToMakeChangeUtil(arr, n - 1, T, dp);
    }

    // Function to count the ways to make change

    /**
     * Time Complexity: O(N*T)
     *
     * Reason: There are two nested loops.
     *
     * Space Complexity: O(T)
     *
     * Reason: We are using an external array of size ‘T+1’ to store two rows only.
     * @param arr
     * @param n
     * @param T
     * @return
     */
    static long countWaysToMakeChange2(int[] arr, int n, int T) {
        // Create an array to store results of subproblems for the previous element
        long[] prev = new long[T + 1];

        // Initialize base condition for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                prev[i] = 1;
            // Else condition is automatically fulfilled, as prev array is initialized to zero
        }

        // Fill the prev array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store results of subproblems for the current element
            long[] cur = new long[T + 1];
            for (int target = 0; target <= T; target++) {
                long notTaken = prev[target];

                long taken = 0;
                if (arr[ind] <= target)
                    taken = cur[target - arr[ind]];

                cur[target] = notTaken + taken;
            }
            prev = cur;
        }

        return prev[T];
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
    }
}
