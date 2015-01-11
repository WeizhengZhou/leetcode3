package zz;

public class BalancedBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public boolean isBalanced(TreeNode root) {
		 if(root==null){
			 return true;
		 }
		 return helper(root)==-1?false:true;
	 }
	 
	 public int helper(TreeNode root){
		 if(root==null){
			 return 0;
		 }
		 int left=helper(root.left);
		 int right=helper(root.right);
		 if(left==-1 || right==-1){
			 return -1;
		 }
		 if(Math.abs(left-right)>1){
			 return -1;
		 }
		 return Math.max(left, right)+1;
	 }
}
