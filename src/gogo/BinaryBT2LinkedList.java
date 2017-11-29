package gogo;

public class BinaryBT2LinkedList {
    public void flatten(TreeNode root) {
        if (root==null) return;
        helper(root);
    }
    private TreeNode helper(TreeNode root) {
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	if (left==null && right == null) return root;
    	TreeNode last = root;
    	if (left!=null) {
    		last = helper(root.left);
    		root.left=null;
    		root.right=left;
    	}
    	if (right!=null) {	
    		last.left = null;
    		last.right = right;
    		last = helper(root.right);
    	}
    	return last;
    }
}
