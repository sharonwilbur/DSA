package Recursion;

// Step 1: Define the Node class (blueprint for each node)
class Node {
    // Fields: data that each node stores
    int key;           // The value stored in this node
    Node left;         // Reference to left child node
    Node right;        // Reference to right child node

    // Constructor: runs when creating a new node
    public Node(int item) {
        key = item;         // Set the value
        left = null;        // Initially no left child
        right = null;       // Initially no right child
    }
}

// Step 2: Define the BinarySearchTree class (manages the tree)
class BinarySearchTree {
    // Field: the starting point of the tree
    Node root;

    // Constructor: creates an empty tree
    public BinarySearchTree() {
        root = null;  // Tree starts empty
    }

    // Method: Insert a new value into the tree
    Node insert(Node root, int key) {
        // BASE CASE: If current position is empty, create new node here
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // RECURSIVE CASE: Find the correct position
        if (key < root.key) {
            // Key is smaller, go to left subtree
            root.left = insert(root.left, key);
        } 
        else if (key > root.key) {
            // Key is larger, go to right subtree
            root.right = insert(root.right, key);
        }

        // Return the (possibly modified) node
        return root;
    }

    // Method: Search for a value in the tree
    boolean search(Node root, int key) {
        // BASE CASE 1: Reached empty position, not found
        if (root == null) 
            return false;

        // BASE CASE 2: Found the value!
        if (root.key == key)
            return true;

        // RECURSIVE CASE: Keep searching
        if (key < root.key)
            return search(root.left, key);   // Search left
        else
            return search(root.right, key);  // Search right
    }

    // Method: Print tree in sorted order (left-root-right)
    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);      // Visit left subtree
            System.out.print(root.key + " "); // Print current node
            inorderTraversal(root.right);     // Visit right subtree
        }
    }

    // Main method: Entry point of the program
    public static void main(String[] args) {
        // Create a BST object
        BinarySearchTree bst = new BinarySearchTree();

        // Values to insert
        int[] keys = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        // Insert each value into the tree
        System.out.println("Inserting values: 8, 3, 10, 1, 6, 14, 4, 7, 13");
        for (int key : keys) {
            bst.root = bst.insert(bst.root, key);
        }

        // Display tree in sorted order
        System.out.print("\nInorder traversal (sorted): ");
        bst.inorderTraversal(bst.root);
        System.out.println();

        // Test search
        int searchKey1 = 6;
        int searchKey2 = 15;

        System.out.println("\nSearch for " + searchKey1 + ": " + 
                           bst.search(bst.root, searchKey1));  // true
        System.out.println("Search for " + searchKey2 + ": " + 
                           bst.search(bst.root, searchKey2));  // false
    }
}
