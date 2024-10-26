package prep.google.interview.backtracking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Given a binary tree, write a recursive algorithm to print all paths from every leaf node to root node in the binary tree.
 *
 * For example, consider the following binary tree:
 *
 *  Print Leaf to Root Path
 *
 *  There are five leaf-to-root paths in the above binary tree:
 *
 * 4 —> 2 —> 15 —> 2 —> 18 —> 6 —> 3 —> 19 —> 6 —> 3 —> 17 —> 3 —> 1
 */


    // A class to store a binary tree node
    class Node1
    {
        int data;
        Node1 left = null, right = null;

        Node1(int data) {
            this.data = data;
        }
    }

    class PrintAllPathFromLeafToNode
    {
        // Function to check if a given node is a leaf node or not
        public static boolean isLeaf(Node1 node) {
            return (node.left == null && node.right == null);
        }

        // Print path present in the list in reverse order (leaf to the root node)
        public static void printPath(Deque<Integer> path)
        {
            Iterator<Integer> itr = path.descendingIterator();
            while (itr.hasNext())
            {
                System.out.print(itr.next());

                if (itr.hasNext()) {
                    System.out.print(" —> ");
                }
            }
            System.out.println();
        }

        // Recursive function to print all paths from leaf-to-root node
        public static void printLeafToRootPaths(Node1 node, Deque<Integer> path)
        {
            // base case
            if (node == null) {
                return;
            }

            // include the current node to the path
            path.addLast(node.data);

            // if a leaf node is found, print the path
            if (isLeaf(node)) {
                printPath(path);
            }

            // recur for the left and right subtree
            printLeafToRootPaths(node.left, path);
            printLeafToRootPaths(node.right, path);

            // backtrack: remove the current node after the left, and right subtree are done
            path.removeLast();
        }

        // The main function to print all paths from leaf-to-root node
        public static void printLeafToRootPaths(Node1 node)
        {
            // Deque to store leaf-to-root path
            Deque<Integer> path = new ArrayDeque<>();

            // call recursive function
            printLeafToRootPaths(node, path);
        }

        public static void main(String[] args)
        {
        /* Construct the following tree
                   1
                 /   \
                /     \
               /       \
              2         3
             / \       / \
            /   \     /   \
           4     5   6     7
                    / \
                   /   \
                  8     9
        */

            Node1 root = new Node1(1);
            root.left = new Node1(2);
            root.right = new Node1(3);
            root.left.left = new Node1(4);
            root.left.right = new Node1(5);
            root.right.left = new Node1(6);
            root.right.right = new Node1(7);
            root.right.left.left = new Node1(8);
            root.right.left.right = new Node1(9);

            // print all leaf-to-root paths
            printLeafToRootPaths(root);
        }
}
