package prep.google.interview.trees;

import java.util.ArrayList;
import java.util.List;

public class LCAOfBinaryTree {

    TreeNode root;
    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    // Finds the path from root TreeTreeNode to given root of the
    // tree.
    //using brute force
    int findLCA1(int n1, int n2)
    {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    private int findLCAInternal(TreeNode root, int n1, int n2)
    {

        if (!findPath(root, n1, path1)
                || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0)
                    ? "n1 is present"
                    : "n1 is missing");
            System.out.println((path2.size() > 0)
                    ? "n2 is present"
                    : "n2 is missing");
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size();
             i++) {

            // System.out.println(path1.get(i) + " " +
            // path2.get(i));
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i - 1);
    }

    // Finds the path from root TreeTreeNode to given root of the
    // tree, Stores the path in a vector path[], returns
    // true if path exists otherwise false
    private boolean findPath(TreeNode root, int n,
                             List<Integer> path)
    {
        // base case
        if (root == null) {
            return false;
        }

        // Store this TreeTreeNode . The TreeTreeNode will be removed if
        // not in path from root to n.
        path.add(root.data);

        if (root.data == n ||
                findPath(root.left, n, path) ||
                findPath(root.right, n, path)) {
            return true;
        }

        // If not present in subtree rooted with root,
        // remove root from path[] and return false
        path.remove(path.size() - 1);

        return false;
    }
    
    //using recursiion


    TreeNode findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }

    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    TreeNode findLCA(TreeNode TreeNode, int n1, int n2)
    {
        // Base case
        if (TreeNode == null)
            return null;

        // If either n1 or n2 matches with root's key,
        // report the presence by returning root (Note that
        // if a key is ancestor of other, then the ancestor
        // key becomes LCA
        if (TreeNode.data == n1 || TreeNode.data == n2)
            return TreeNode;

        // Look for keys in left and right subtrees
        TreeNode left_lca = findLCA(TreeNode.left, n1, n2);
        TreeNode right_lca = findLCA(TreeNode.right, n1, n2);

        // If both of the above calls return Non-NULL, then
        // one key is present in once subtree and other is
        // present in other, So this TreeNode is the LCA
        if (left_lca != null && right_lca != null)
            return TreeNode;

        // Otherwise check if left subtree or right subtree
        // is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    // Driver code
    public static void main(String[] args)
    {
        LCAOfBinaryTree tree
                = new LCAOfBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        System.out.println("LCA(4, 5) = "
                + tree.findLCA(4, 5));
        System.out.println("LCA(4, 6) = "
                + tree.findLCA(4, 6));
        System.out.println("LCA(3, 4) = "
                + tree.findLCA(3, 4));
        System.out.println("LCA(2, 4) = "
                + tree.findLCA(2, 4));
    }
}
