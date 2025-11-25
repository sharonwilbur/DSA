package Tree;

public class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val)
  {
    this.val=val;
    this.left=null;
    this.right=null;
  }
}
public class MaximumDepthOfBinaryTree_LC104 {
  
  int maxDepth(TreeNode root)
  {
    if(root==null)
    {
      return 0;
    }
    return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
  }
  public static void main(String[] args) {
    MaximumDepthOfBinaryTree_LC104 maxDepth = new MaximumDepthOfBinaryTree_LC104();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(maxDepth.maxDepth(root));
  }
}
