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

public class PreorderTraversal_LC144 {
    // Method for inorder traversal
    void PreorderTraversal(TreeNode root) {
        if(root==null)
        {
            return ;
        }
        System.out.println(root.val+" ");
        PreorderTraversal(root.left);
        PreorderTraversal(root.right);
    }

    public static void main(String[] args) {
        PreorderTraversal_LC144 tree = new PreorderTraversal_LC144();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        tree.PreorderTraversal(root);  // Output will be: 4 2 5 1 3
    }
}


