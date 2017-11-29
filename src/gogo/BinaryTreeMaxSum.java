package gogo;

public class BinaryTreeMaxSum {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxPath(root);
		return max;
	}
    private int maxPath(TreeNode root) {
        if (root==null) return 0;
        int leftSum = maxPath(root.left);
        int rightSum = maxPath(root.right);
        int maxSum = root.val;
        int leftMax = root.val;
        int rightMax = root.val;
        if (leftSum>0) {
        	maxSum+=leftSum;
        	leftMax+=leftSum;
        }
        if (rightSum>0) {
        	maxSum+=rightSum;
        	rightMax+=rightSum;
        }
        max=Math.max(max, maxSum);
        return Math.max(leftMax, rightMax);
    }
}
