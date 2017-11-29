package gogo;

public class SumRootLeafNumber {
	int sum=0;
    public int sumNumbers(TreeNode root) {
        if (root==null) return 0;
        helper(root,0);
        return sum;
    }
    private void helper(TreeNode node, int pre) {
    	int cur = pre*10+node.val;
    	if (node.left==null && node.right == null){
    		sum+=cur;
    		return;
    	}
    	if (node.left!=null) {
    		helper(node.left, cur);
    	}
    	if (node.right !=null) {
    		helper(node.right, cur);
    	}
    }
}
