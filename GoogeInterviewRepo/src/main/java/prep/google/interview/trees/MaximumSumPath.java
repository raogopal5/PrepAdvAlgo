package prep.google.interview.trees;

/**
 * Given a Binary Tree, determine the maximum sum achievable along any path within the tree. A path in a binary tree is defined as a sequence of TreeNodes where each pair of adjacent TreeNodes is connected by an edge. TreeNodes can only appear once in the sequence, and the path is not required to start from the root.
 * Identify and compute the maximum sum possible along any path within the given binary tree.
 */
public class MaximumSumPath {

    /**
     * Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each node exactly once during the recursive traversal.
     *
     * Space Complexity: O(1) as no additional space or data structures is created that is proportional to the input size of the tree. O(H) Recursive Stack Auxiliary Space : The recursion stack space is determined by the maximum depth of the recursion, which is the height of the binary tree denoted as H.
     * In the balanced case it is log2N and in the worst case its N.
     * @param root
     * @param maxi
     * @return
     */
    public int findMaxPathSum(TreeNode root, int[] maxi) {
        // Base case: If the current TreeNode is null, return 0
        if (root == null) {
            return 0;
        }

        // Calculate the maximum path sum
        // for the left and right subtrees
        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));

        // Update the overall maximum
        // path sum including the current TreeNode
        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.data);

        // Return the maximum sum considering
        // only one branch (either left or right)
        // along with the current TreeNode
        return Math.max(leftMaxPath, rightMaxPath) + root.data;
    }

    // Function to find the maximum
    // path sum for the entire binary tree
    int maxPathSum(TreeNode root) {
        // Initialize maxi to the
        // minimum possible integer value
        int[] maxi = {Integer.MIN_VALUE};

        // Call the recursive function to
        // find the maximum path sum
        findMaxPathSum(root, maxi);

        // Return the final maximum path sum
        return maxi[0];
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        // Creating an instance of the Solution class
        MaximumSumPath solution = new MaximumSumPath();

        // Finding and printing the maximum path sum
        int maxPathSum = solution.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }

}
