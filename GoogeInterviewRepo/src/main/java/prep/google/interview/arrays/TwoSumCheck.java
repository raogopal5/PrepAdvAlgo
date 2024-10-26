package prep.google.interview.arrays;

/**
 *st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
 *
 * 2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.
 */
public class TwoSumCheck {

    public static String twoSum(int n, int []arr, int target) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target)
                    return "YES";
            }
        }
        return "NO";
    }

    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        String ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 1: " + ans);
    }


}
