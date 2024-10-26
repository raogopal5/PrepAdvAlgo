package prep.google.interview.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a Binary Tree, return the height of the tree.
 * The height of the tree is equal to the number of TreeNodes on the longest path from root to a leaf.
 * Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This complexity arises from visiting each
 * node exactly once during the traversal to determine the maximum depth.
 *
 * Space Complexity: O(N) where N is the number of nodes in the Binary Tree because in the worst case scenario the tree is balanced and has N/2 nodes
 * in its last level which will have to be stored in the queue.
 */
public class MaximumDepthInBinaryTree {

    int maxDepth(TreeNode root) {
        // If the root is NULL
        // (empty tree), depth is 0
        if (root == null) {
            return 0;
        }

        // Create a queue for
        // level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;

        // Push the root TreeNode into the queue
        q.add(root);

        // While there are TreeNodes in the queue
        while (!q.isEmpty()) {
            // Get the number of TreeNodes
            // at the current level
            int size = q.size();

            // Process all TreeNodes
            // at the current level
            for (int i = 0; i < size; i++) {
                // Get the front TreeNode in the queue
                TreeNode front = q.poll();

                // Enqueue left child if exists
                if (front.left != null) {
                    q.add(front.left);
                }

                // Enqueue right child if exists
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            // Increment level to
            // move to the next level
            level++;
        }
        // Return the level, which represents
        // the maximum depth of the tree
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        MaximumDepthInBinaryTree solution = new MaximumDepthInBinaryTree();
        int depth = solution.maxDepth(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}
