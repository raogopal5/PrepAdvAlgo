package prep.google.interview.trees;

public class BinaryTreeCustom {

    TreeNode root;



    //Binary search tree insert operation
    public TreeNode addRecursive(TreeNode current,int data){
        if(current==null){
            return new TreeNode(data);
        }
        else if(data < current.data){
            current.left =addRecursive(current.left,data);
        }else if(data > current.data){
            current.right = addRecursive(current.right,data);
        }else{
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public void traverseTree(TreeNode node) {
        if (node != null) {
            traverseTree(node.left);
            System.out.print(" " + node.data);
            traverseTree(node.right);
        }
    }

    private boolean containsNodeRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        }
        return value < current.data
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    private TreeNode deleteRecursive(TreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.data) {
            // Node to delete found
            // ... code to delete the node will go here
        }
        if (value < current.data) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private int findSmallestValue(TreeNode root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    public static void main(String[] args) {
        BinaryTreeCustom binaryTree = new BinaryTreeCustom();
        // create nodes of the binaryTree
        binaryTree.root = new TreeNode(1);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.left.left = new TreeNode(4);
        System.out.print("\nBinary Tree: ");
        binaryTree.traverseTree(binaryTree.root);

        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(9);
        System.out.println(binaryTree);

    }

}
