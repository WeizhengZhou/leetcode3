package gogo;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return root;
        TreeNode left=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(left);
        return root;
    }
}
