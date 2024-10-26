package prep.google.interview.dynamicprogramming;

import java.util.Arrays;

/**
 * Given an array of ‘N’  positive integers, we need to return the maximum sum of the subsequence such that no two elements of the subsequence are adjacent elements in the array.
 *
 * Note: A subsequence of an array is a list with elements of the array where
 * some elements are deleted ( or not deleted at all) and the elements should be in the same order in the subsequence as in the array.
 * Time Complexity: O(N)
 *
 * Reason: The overlapping subproblems will return the answer in constant time O(1). Therefore the total number of new subproblems we solve is ‘n’. Hence total time complexity is O(N).
 *
 * Space Complexity: O(N)
 *
 */
public class MaximumSumNonAdjacent {

    // This function recursively calculates the maximum possible sum
    // by considering or not considering the current element.
    static int solveUtil(int ind, int[] arr, int[] dp) {
        // If the index is negative, there are no elements left to consider.
        if (ind < 0) return 0;

        // If the index is 0, there is only one element to consider, so return its value.
        if (ind == 0) return arr[ind];

        // If we have already calculated the result for this index, return it.
        if (dp[ind] != -1) return dp[ind];

        // Calculate the maximum sum by either picking the current element or not picking it.
        int pick = arr[ind] + solveUtil(ind - 2, arr, dp);
        int nonPick = solveUtil(ind - 1, arr, dp);

        // Store the maximum of the two options in the dp array for future reference.
        return dp[ind] = Math.max(pick, nonPick);
    }

    // This function initializes the dp array and calls the recursive solver.
    static int solve(int n, int[] arr) {
        int dp[] = new int[n];

        // Initialize the dp array with -1 to indicate that values are not calculated yet.
        Arrays.fill(dp, -1);

        // Call the recursive solver for the last index (n-1).
        return solveUtil(n - 1, arr, dp);
    }

    public static void main(String args[]) {
        // Input array with elements.
        int arr[] = {2, 1, 4, 9};

        // Get the length of the array.
        int n = arr.length;

        // Call the solve function to find the maximum possible sum.
        int result = solve(n, arr);

        // Print the result.
        System.out.println(result);
    }
}
