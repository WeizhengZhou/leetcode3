package dp;

public class MaxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root==null){
        	return 0;
        }
        helper(root);
        return max;
    }
    
    public int helper(TreeNode r){
    	if(r==null){
    		return 0;
    	}
    	int lSum=helper(r.left);
    	int rSum=helper(r.right);
    	int pathSum=Math.max(Math.max(lSum,rSum)+r.val, r.val);
    	int sum=lSum+rSum+r.val;
    	max=Math.max(Math.max(pathSum, sum), max);
    	return pathSum;
    }

}
