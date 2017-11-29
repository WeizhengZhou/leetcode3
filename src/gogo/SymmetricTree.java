package gogo;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode x, TreeNode y) {
    	if (x==null && y==null) return true;
    	if (x==null || y==null) return false;
    	if (x.val != y.val) return false;
    	return helper(x.left, y.right) && helper(x.right, y.left);
    }
}
