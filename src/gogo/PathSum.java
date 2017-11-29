package gogo;

public class PathSum {
	 public boolean hasPathSum(TreeNode root, int sum) {
	        if (root==null) return false;
	        return helper(root,sum);
	    }
	    public boolean helper(TreeNode root, int sum) {
	        if (root.left==null && root.right==null) return sum==root.val;
	        if (root.left==null) return helper(root.right, sum-root.val);
	        if (root.right==null) return helper(root.left,sum-root.val);        
	        return helper(root.left,sum-root.val) || helper(root.right, sum-root.val);
	    }
}
