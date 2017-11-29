package gogo;

public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null || nums.length==0) return null;
        return helper(0,nums.length-1,nums);
    }
    private TreeNode helper(int l, int r, int[] nums) {
    	if (l>r) return null;
    	if (l==r) return new TreeNode(nums[l]);
    	int m = (l+r)/2;
    	TreeNode root = new TreeNode(nums[m]);
    	root.left = helper(l,m-1,nums);
    	root.right = helper(m+1,r,nums);
    	return root;
    }
}
