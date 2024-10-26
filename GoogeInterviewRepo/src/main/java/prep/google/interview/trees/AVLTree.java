package prep.google.interview.trees;

/**
 * AVL tree is a self-balancing Binary Search Tree (BST)
 * where the difference between heights of left and right subtrees cannot be more than one for all nodes.
 */
public class AVLTree {


    AVLNode root;

    // A utility function to get the height of the tree 
    int height(AVLNode N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers 
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y 
    // See the diagram given above. 
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation 
        x.right = y;
        y.left = T2;

        // Update heights 
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root 
        return x;
    }

    // A utility function to left rotate subtree rooted with x 
    // See the diagram given above. 
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation 
        y.left = x;
        x.right = T2;

        //  Update heights 
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root 
        return y;
    }

    // Get Balance factor of AVLNode N 
    int getBalance(AVLNode N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    AVLNode insert(AVLNode AVLNode, int key) {

        /* 1.  Perform the normal BST insertion */
        if (AVLNode == null)
            return (new AVLNode(key));

        if (key < AVLNode.key)
            AVLNode.left = insert(AVLNode.left, key);
        else if (key > AVLNode.key)
            AVLNode.right = insert(AVLNode.right, key);
        else // Duplicate keys not allowed 
            return AVLNode;

        /* 2. Update height of this ancestor AVLNode */
        AVLNode.height = 1 + max(height(AVLNode.left),
                height(AVLNode.right)); 
  
        /* 3. Get the balance factor of this ancestor 
              AVLNode to check whether this AVLNode became 
              unbalanced */
        int balance = getBalance(AVLNode);

        // If this AVLNode becomes unbalanced, then there 
        // are 4 cases Left Left Case 
        if (balance > 1 && key < AVLNode.left.key)
            return rightRotate(AVLNode);

        // Right Right Case 
        if (balance < -1 && key > AVLNode.right.key)
            return leftRotate(AVLNode);

        // Left Right Case 
        if (balance > 1 && key > AVLNode.left.key) {
            AVLNode.left = leftRotate(AVLNode.left);
            return rightRotate(AVLNode);
        }

        // Right Left Case 
        if (balance < -1 && key < AVLNode.right.key) {
            AVLNode.right = rightRotate(AVLNode.right);
            return leftRotate(AVLNode);
        }

        /* return the (unchanged) AVLNode pointer */
        return AVLNode;
    }

    // A utility function to print preorder traversal 
    // of the tree. 
    // The function also prints height of every AVLNode 
    void preOrder(AVLNode AVLNode) {
        if (AVLNode != null) {
            System.out.print(AVLNode.key + " ");
            preOrder(AVLNode.left);
            preOrder(AVLNode.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25); 
  
        /* The constructed AVL Tree would be 
             30 
            /  \ 
          20   40 
         /  \     \ 
        10  25    50 
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
    }
}
