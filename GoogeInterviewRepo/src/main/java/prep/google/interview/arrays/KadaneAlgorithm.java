package prep.google.interview.arrays;

/**
 * Given an integer array arr, find the contiguous subarray (containing at least one number) which
 * has the largest sum and returns its sum and prints the subarray.
 */
public class KadaneAlgorithm {

    /**
     * Using brute force
     *
     * @param arr Time Complexity: O(N3), where N = size of the array.
     *            Reason: We are using three nested loops, each running approximately N times.
     *            <p>
     *            Space Complexity: O(1) as we are not using any extra space.
     * @param n
     * @return
     */
    public static int maxSubarraySum(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // subarray = arr[i.....j]
                int sum = 0;

                //add all the elements of subarray:
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                maxi = Math.max(maxi, sum);
            }
        }

        return maxi;
    }

    /**
     * Using two loop
     *
     * @param arr Time Complexity: O(N2), where N = size of the array.
     *            Reason: We are using two nested loops, each running approximately N times.
     *            <p>
     *            Space Complexity: O(1) as we are not using any extra space.
     * @param n
     * @return
     */
    public static int maxSubArraySumUsingTwoLoop(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // current subarray = arr[i.....j]

                //add the current element arr[j]
                // to the sum i.e. sum of arr[i...j-1]
                sum += arr[j];

                maxi = Math.max(maxi, sum); // getting the maximum
            }
        }
        return maxi;
    }


        public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maxSubarraySum(arr, n);
        int maxSum2 = maxSubArraySumUsingTwoLoop(arr,n);
        System.out.println("The maximum subarray sum is: " + maxSum);
        System.out.println("The maximum subarray sum is: " + maxSum2);

    }
}
