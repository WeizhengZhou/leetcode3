package dp;

public class BalancedBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isBalanced(TreeNode root) {
        if (root==null){
        	return false;
        }
        helper(root);
        return helper(root)==-1?false:true;
    }
    
    public int helper(TreeNode r){
    	if (r==null){
    		return 0;
    	}
    	int left=helper(r.left);
    	int right=helper(r.right);
    	if (Math.abs(left-right)>1||left==-1||right==-1){
    		return -1;
    	}
    	return Math.max(left, right)+1;
    	
    }

}
