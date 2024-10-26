package prep.google.interview.trees;

/**
 * Given two Binary Trees, return if true if the two trees are identical, otherwise return false.
 */
public class CheckTwoBinarytreeEqual {

    /**
     * Step 1: Start at the root TreeNode of both trees (TreeNode1 and TreeNode2).
     *
     * Step 2: Check if the values of the current TreeNodes in both trees are equal. If not return false.
     *
     * Step 3: Recursively check the left then right subtree of the current TreeNode in both trees is identical.
     *
     * Step 4: If all the recursive checks return true, then return the trees are identical, otherwise they are not.
     * Time Complexity: O(N+M) where N is the number of TreeNodes in the first Binary Tree and M is the number of TreeNodes in the second Binary Tree.
     * This complexity arises from visiting each TreeNode of the two binary TreeNodes during their comparison.
     *
     * Space Complexity: O(1) as no additional space or data structures is created that is proportional to the input
     *
     * size of the tree. O(H) Recursive Stack Auxiliary Space : The recursion stack space is determined by
     * the maximum depth of the recursion, which is the height of the binary tree denoted as H.
     * In the balanced case it is log2N and in the worst case (its N).
     */

    // Function to check if two
    // binary trees are identical
    public boolean isIdentical(TreeNode TreeNode1, TreeNode TreeNode2) {
        // If both TreeNodes are NULL,
        // they are identical
        if (TreeNode1 == null && TreeNode2 == null) {
            return true;
        }
        // If only one of the TreeNodes is
        // NULL, they are not identical
        if (TreeNode1 == null || TreeNode2 == null) {
            return false;
        }
        // Check if the current TreeNodes
        // have the same data value
        // and recursively check their
        // left and right subtrees
        return ((TreeNode1.data == TreeNode2.data)
                && isIdentical(TreeNode1.left, TreeNode2.left)
                && isIdentical(TreeNode1.right, TreeNode2.right));
    }

    public static void main(String[] args) {
        // TreeNode1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);

        // TreeNode2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);

        CheckTwoBinarytreeEqual solution = new CheckTwoBinarytreeEqual();

        if (solution.isIdentical(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }
    }
}
