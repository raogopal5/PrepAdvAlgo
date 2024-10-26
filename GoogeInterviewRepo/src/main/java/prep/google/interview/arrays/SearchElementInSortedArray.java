package prep.google.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k. Now the array is rotated
 *  at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.
 */
public class SearchElementInSortedArray {

    /**
     * Time Complexity: O(N), N = size of the given array.
     * Reason: We have to iterate through the entire array to check if the target is present in the array.
     *
     * Space Complexity: O(1)
     * Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).
     * @param arr
     * @param n
     * @param k
     * @return
     */

    public static int search(ArrayList<Integer> arr, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == k)
                return i;
        }
        return -1;
    }

    /**Time Complexity: O(logN), N = size of the given array.
     Reason: We are using binary search to search the target.

     Space Complexity: O(1)
     Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).
     * Using Binary search
     * @param args
     */

    public static int searchBinary(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // if mid points to the target
            if (arr.get(mid) == k)
                return mid;

            // if left part is sorted
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) <= k && k <= arr.get(mid)) {
                    // element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if (arr.get(mid) <= k && k <= arr.get(high)) {
                    // element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
        int n = 9, k = 1;
        int ans = search(arr, n, k);
        if (ans == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }
}
