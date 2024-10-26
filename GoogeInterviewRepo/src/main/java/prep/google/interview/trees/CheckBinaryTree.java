package prep.google.interview.trees;

/**
 * A Binary Search Tree (BST) is a TreeNode-based binary tree data structure that has the following properties.
 *
 * The left subtree of a TreeNode contains only TreeNodes with keys less than the TreeNode’s key.
 * The right subtree of a TreeNode contains only TreeNodes with keys greater than the TreeNode’s key.
 * Both the left and right subtrees must also be binary search trees.
 * Each TreeNode (item in the tree) has a distinct key.
 */
public class CheckBinaryTree {

    static int maxValue(TreeNode TreeNode)
    {
        if (TreeNode == null) {
            return Integer.MIN_VALUE;
        }
        int value = TreeNode.data;
        int leftMax = maxValue(TreeNode.left);
        int rightMax = maxValue(TreeNode.right);

        return Math.max(value, Math.max(leftMax, rightMax));
    }

    static int minValue(TreeNode TreeNode)
    {
        if (TreeNode == null) {
            return Integer.MAX_VALUE;
        }
        int value = TreeNode.data;
        int leftMax = minValue(TreeNode.left);
        int rightMax = minValue(TreeNode.right);

        return Math.min(value, Math.min(leftMax, rightMax));
    }

    /* Returns true if a binary tree is a binary search tree
     */
    static boolean isBST(TreeNode TreeNode)
    {
        if (TreeNode == null) {
            return true;
        }

        /* false if the max of the left is > than us */
        if (TreeNode.left != null
                && maxValue(TreeNode.left) > TreeNode.data) {
            return false;
        }

        /* false if the min of the right is <= than us */
        if (TreeNode.right != null
                && minValue(TreeNode.right) < TreeNode.data) {
            return false;
        }

        /* false if, recursively, the left or right is not a
         * BST*/
        if (isBST(TreeNode.left) == false
                || isBST(TreeNode.right) == false) {
            return false;
        }

        /* passing all that, it's a BST */
        return true;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        // root->right->left = newTreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Function call
        if (isBST(root)) {
            System.out.print("Is BST");
        }
        else {
            System.out.print("Not a BST");
        }
    }
}
