package gogo;

public class KthSmallestInBST {
	int count=0;
	int val=0;
    public int kthSmallest(TreeNode root, int k) {
        if (root==null) return 0;
        helper(root,k);  
        return val;
    }
    private void helper(TreeNode root, int k) {
    	if (root==null) return;
    	helper(root.left,k);
    	count++;
    	if (count==k) {
    		val=root.val;
    		return;
    	}
    	helper(root.right,k);
    }
}
