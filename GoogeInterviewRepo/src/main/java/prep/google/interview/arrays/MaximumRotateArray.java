package prep.google.interview.arrays;

public class MaximumRotateArray {

    /**
     *Time Complexity: O(N), N = size of the given array.
     * Reason: We have to iterate through the entire array to check if the target is present in the array.
     *
     * Space Complexity: O(1)
     * Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1)
     * @param arr
     * @return
     */
    public static int findMinUsingBruteForce(int []arr) {
        int n = arr.length; // size of the array.
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // Always keep the minimum.
            mini = Math.min(mini, arr[i]);
        }
        return mini;
    }


    /**
     * Using Binary search
     * ime Complexity: O(logN), N = size of the given array.
     * Reason: We are basically using binary search to find the minimum.
     *
     * Space Complexity: O(1)
     * Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).
     * @param arr
     * @return
     */
    public static int findMin(int []arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findMin(arr);
        System.out.println("The minimum element is: " + ans );
    }
}
