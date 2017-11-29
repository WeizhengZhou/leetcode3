package gogo;

public class MinDepth {
	public int minDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left == null && root.right==null) return 1;
        int left = minDepth(root.left);
    	int right = minDepth(root.right);
    	if (left==0) return right+1;
    	if (right==0) return left+1;
    	return Math.min(left, right) +1;
    }
    
    private int helper(TreeNode root) {
    	if (root==null) return 0;
    	int left = helper(root.left);
    	int right = helper(root.right);
    	if (left< 0|| right<0) return -1;
    	if (Math.abs(left-right)>1) return -1;
    	return Math.max(left, right) + 1;
    }
}
