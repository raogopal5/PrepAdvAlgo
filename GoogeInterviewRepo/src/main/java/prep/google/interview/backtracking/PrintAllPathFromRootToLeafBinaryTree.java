package prep.google.interview.backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Print all paths from the root to leaf nodes of a binary tree
 * Given a binary tree, write an efficient algorithm to print all paths from the root node to every leaf node in it.
 *
 * For example, consider the following binary tree:
 *
 *  Root To Leaf Paths in Binary Tree
 *
 * The binary tree has four root-to-leaf paths: 1 —> 2 —> 41 —> 2 —> 51 —> 3 —> 6 —> 81 —> 3 —> 7 —> 9
 */

    class Node
    {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }

    class PrintAllPathFromRootToLeafBinaryTree
    {
        // Function to check if a given node is a leaf node or not
        public static boolean isLeaf(Node node) {
            return (node.left == null && node.right == null);
        }

        // Recursive function to find paths from the root node to every leaf node
        public static void printRootToLeafPaths(Node node, Deque<Integer> path)
        {
            // base case
            if (node == null) {
                return;
            }

            // include the current node to the path
            path.addLast(node.data);

            // if a leaf node is found, print the path
            if (isLeaf(node)) {
                System.out.println(path);
            }

            // recur for the left and right subtree
            printRootToLeafPaths(node.left, path);
            printRootToLeafPaths(node.right, path);

            // backtrack: remove the current node after the left, and right subtree are done
            path.removeLast();
        }

        // The main function to print paths from the root node to every leaf node
        public static void printRootToLeafPaths(Node node)
        {
            // list to store root-to-leaf path
            Deque<Integer> path = new ArrayDeque<>();
            printRootToLeafPaths(node, path);
        }

        public static void main(String[] args)
        {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
                   /     \
                  8       9
        */

            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
            root.right.left.left = new Node(8);
            root.right.right.right = new Node(9);

            // print all root-to-leaf paths
            printRootToLeafPaths(root);
        }
}
