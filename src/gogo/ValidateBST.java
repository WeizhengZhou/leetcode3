package gogo;

class Pair {
	int min;
	int max;
	Pair(int x, int y) {
		min=x;
		max=y;
	}
}

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long min, long max) {
    	if (root==null) return true;
    	if (root.val<min || root.val>max) return false;
    	return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}
