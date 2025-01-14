package prep.google.interview.trees;

import sun.reflect.generics.tree.Tree;

public class TreeNode {

    public int data;
    public TreeNode left;
    public  TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
