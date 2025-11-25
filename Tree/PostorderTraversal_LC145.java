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

public class PostorderTraversal_LC145 {
    // Method for inorder traversal
    void postorderTraversal(TreeNode root) {
        if(root==null)
        {
            return ;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.val+" ");
    }

    public static void main(String[] args) {
        PostorderTraversal_LC145 tree = new PostorderTraversal_LC145();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        tree.postorderTraversal(root);  // Output will be: 4 2 5 1 3
    }
}

