package prep.google.interview.arrays;

/**
 * Given an array that contains both negative and positive integers, find the maximum product subarray.
 */
public class MaximumProductSubArray {
    /**
     *
     * @param arr
     * @return
     */
    public static int maxProductSubArray(int arr[]) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= arr[k];
                    result = Math.max(result, prod);
                }
            }

        }
        return result;
    }

    /**
     *Time Complexity: O(N2)
     *
     * Reason: We are using two nested loops
     *
     * Space Complexity: O(1)
     *
     * Reason: No extra data stru
     * @param arr
     * @return
     */
    static int maxProductSubArrayUsingTwoLoop(int arr[]) {
        int result = arr[0];
        for(int i=0;i<arr.length-1;i++) {
            int p = arr[i];
            for(int j=i+1;j<arr.length;j++) {
                result = Math.max(result,p);
                p *= arr[j];
            }
            result = Math.max(result,p);
        }
        return result;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
        int answer = maxProductSubArray(nums);
        int answer2 = maxProductSubArrayUsingTwoLoop(nums);
        System.out.print("The maximum product subarray is: "+answer);
        System.out.println("----");
        System.out.print("The maximum product subarray is: "+answer2);
    }

}
