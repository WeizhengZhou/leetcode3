package xx;

public class BalancedBT {
	public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        return helper(root)!=-1;
 }
 private int helper(TreeNode root){
     if(root==null){return 0;}
     int left=helper(root.left);
     int right=helper(root.right);
     if(left==-1 ||right==-1)return -1;
     if(Math.abs(left-right)>1)return -1;
     return Math.max(left,right)+1;
 }	
}
