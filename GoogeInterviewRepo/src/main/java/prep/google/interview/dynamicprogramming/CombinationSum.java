package prep.google.interview.dynamicprogramming;


import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers and a target, you have to return the list of all unique combinations where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from the given array an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Examples:
 *
 * Example 1:
 *
 * Input: array = [2,3,6,7], target = 7
 * ime Complexity: O(2^t * k) where t is the target, k is the average length
 *
 * Reason: Assume if you were not allowed to pick a single element multiple times, every element will have a couple of options: pick or not pick which is 2^n different recursion calls, also assuming that the average length of every combination generated is k. (to put length k data structure into another data structure)
 *
 * Why not (2^n) but (2^t) (where n is the size of an array)?
 *
 * Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or not pick” an element.
 *
 * Space Complexity: O(k*x), k is the average length and x is the no. of combinations
 *
 * Output: [[2,2,3],[7]]
 */
public class CombinationSum {

    private void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList < > (ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }
    public List < List < Integer >> combinationSum(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,6,7};
        int target = 7;
        CombinationSum sol = new CombinationSum();
        List <List< Integer >> ls = sol.combinationSum(arr, target);
        System.out.println("Combinations are: ");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
