package prep.google.interview.backtracking;

import java.util.Arrays;

/**
 * Print all triplets in an array with a sum less than or equal to a given number
 * Given an unsorted integer array, print all triplets in it with sum less than or equal to a given number.
 */
public class PrintAllTripletsSum {


    // Function to print all distinct triplets in the array with a sum
    // less than or equal to a given number
    public static void printAllTriplets(int[] nums, int sum)
    {
        // sort the array in ascending order
        Arrays.sort(nums);

        // check if triplet is formed by `nums[i]` and a pair from
        // subarray `nums[i+1…n)`
        for (int i = 0; i <= nums.length - 3; i++)
        {
            // maintain two indexes pointing to endpoints of the
            // subarray `nums[i+1…n)`
            int low = i + 1, high = nums.length - 1;

            // loop if `low` is less than `high`
            while (low < high)
            {
                // decrement `high` if the total is more than the remaining sum
                if (nums[i] + nums[low] + nums[high] > sum) {
                    high--;
                }
                else {
                    // if the total is less than or equal to the remaining sum,
                    // print all triplets
                    for (int x = low + 1; x <= high; x++)
                    {
                        System.out.println("(" + nums[i] + ", " + nums[low] + ", "
                                + nums[x] + ")");
                    }

                    low++;        // increment low
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 2, 7, 4, 9, 5, 1, 3 };
        int sum = 10;

        printAllTriplets(nums, sum);
    }
}
