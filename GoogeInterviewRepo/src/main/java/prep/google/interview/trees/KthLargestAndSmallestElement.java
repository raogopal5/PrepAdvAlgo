package prep.google.interview.trees;

/**
 * Given a Binary Search Tree and an integer ‘K’. Find and return the ‘K-th’ smallest and ‘K-th’ largest element in the given Binary Search Tree
 */
public class KthLargestAndSmallestElement {

    /**
     * Time Complexity: O(N) where N is the number of nodes in the Binary Search Tree as we traverse in inorder and reverse inorder fashion to get to the required nodes. We visit each node once resulting in time complexity proportional to the number of nodes in the BST.
     *
     * Space Complexity : as no additional space is allocated or data structures used to store any values.
     * @param node
     * @param counter
     * @param k
     * @param kLargest
     */
    private void reverseInorder(TreeNode node, int[] counter, int k, int[] kLargest) {
        if (node == null || counter[0] >= k) return;

        // Traverse right subtree
        reverseInorder(node.right, counter, k, kLargest);

        // Increment counter after
        // visiting right subtree
        counter[0]++;

        // Check if current node
        // is the Kth largest
        if (counter[0] == k) {
            kLargest[0] = node.data;
            return;
        }

        // Traverse left subtree if
        // Kth largest is not found yet
        reverseInorder(node.left, counter, k, kLargest);
    }

    private void inorder(TreeNode node, int[] counter, int k, int[] kSmallest) {
        if (node == null || counter[0] >= k) return;

        // Traverse left subtree
        inorder(node.left, counter, k, kSmallest);

        // Increment counter after visiting left subtree
        counter[0]++;

        // Check if current node is the Kth smallest
        if (counter[0] == k) {
            kSmallest[0] = node.data;
            return;
        }

        // Traverse right subtree if
        // Kth smallest is not found yet
        inorder(node.right, counter, k, kSmallest);
    }

    public int[] findKth(TreeNode root, int k) {
        int[] kSmallest = new int[]{Integer.MIN_VALUE};
        int[] kLargest = new int[]{Integer.MIN_VALUE};
        // Counter to track visited nodes
        int[] counter = new int[]{0};

        // Find Kth smallest element
        // (perform inorder traversal)
        inorder(root, counter, k, kSmallest);

        // Reset counter for Kth largest element
        counter[0] = 0;
        // Find Kth largest element
        // (perform reverse inorder traversal)
        reverseInorder(root, counter, k, kLargest);

        return new int[]{kSmallest[0], kLargest[0]};
    }
}

// Function to perform an in-order traversal
// of a binary tree and print its nodes
class BinaryTree {
    // Recursive function to perform in-order traversal
    private void printInOrder(TreeNode root) {
        // Check if the current node
        // is null (base case for recursion)
        if (root == null) {
            // If null, return and
            // terminate the function
            return;
        }

        // Recursively call printInOrder
        // for the left subtree
        printInOrder(root.left);

        // Print the value of the current node
        System.out.print(root.data + " ");

        // Recursively call printInOrder
        // for the right subtree
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // Creating a BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        System.out.println("Binary Search Tree: ");
        new BinaryTree().printInOrder(root);
        System.out.println();

        KthLargestAndSmallestElement solution = new KthLargestAndSmallestElement();

        // Find the Kth smallest and largest elements
        int k = 3;
        System.out.println("k: " + k);
        int[] kthElements = solution.findKth(root, k);

        System.out.println("Kth smallest element: " + kthElements[0]);
        System.out.println("Kth largest element: " + kthElements[1]);
    }
}
