package prep.google.interview.divideandconquer;

public class FindMaxElementInArrayDivideAndConquerExample {

    //Divide and Conquer Algorithm is a problem-solving technique used to solve problems by dividing the main problem into
    // subproblems, solving them individually and then merging them to find solution to the original problem. In this article,
    // we are going to discuss how Divide and Conquer Algorithm is helpful and how we can use it to solve problems.

    //Dividing the Problem: The first step is to break the problem into smaller, more manageable subproblems. This division can be done recursively until the subproblems become simple enough to solve directly.
    //Independence of Subproblems: Each subproblem should be independent of the others, meaning that solving one subproblem does not depend on the solution of another. This allows for parallel processing or
    // concurrent execution of subproblems, which can lead to efficiency gains.
    //Conquering Each Subproblem: Once divided, the subproblems are solved individually.
    //
    // This may involve applying the same divide and conquer approach recursively until the subproblems
    // become simple enough to solve directly, or it may involve applying a different algorithm or technique.
    //Combining Solutions: After solving the subproblems, their solutions are combined to obtain the solution to
    // the original problem. This combination step should be relatively efficient and straightforward, as the solutions to
    // the subproblems should be designed to fit together seamlessly.

    static int findMax(int[] a, int lo, int hi)
    {
        // If lo becomes greater than hi, then return
        // minimum integer possible
        if (lo > hi)
            return Integer.MIN_VALUE;
        // If the subarray has only one element, return the
        // element
        if (lo == hi)
            return a[lo];
        int mid = (lo + hi) / 2;
        // Get the maximum element from the left half
        int leftMax = findMax(a, lo, mid);
        // Get the maximum element from the right half
        int rightMax = findMax(a, mid + 1, hi);
        // Return the maximum element from the left and
        // right half
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int []d ={3,1,5,4};
        int c = FindMaxElementInArrayDivideAndConquerExample.findMax(d,1,2);
        System.out.println(c);
    }
}
