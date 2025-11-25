package Tree;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class InorderTraversal_LC94 {
    // Method for inorder traversal
    void inorderTraversal(TreeNode root) {
        if(root==null)
        {
            return ;
        }
        inorderTraversal(root.left);
        System.out.println(root.val+" ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        InorderTraversal_LC94 tree = new InorderTraversal_LC94();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        tree.inorderTraversal(root);  // Output will be: 4 2 5 1 3
    }
}

