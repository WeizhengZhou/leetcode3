package xx;

public class BTMaxPathSUm {
	int max=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
	}
	private int helper(TreeNode root){
	    if(root==null) return 0;
	    int leftSum=helper(root.left);
	    int rightSum=helper(root.right);
	    int oneWaySum=Math.max(leftSum,rightSum)+root.val;
	    oneWaySum=Math.max(oneWaySum,root.val);
	    int curMax=Math.max(oneWaySum,leftSum+rightSum+root.val);
	    max=Math.max(max,curMax);
	    return oneWaySum;
	}
}
