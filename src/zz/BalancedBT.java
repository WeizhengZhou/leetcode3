//zz reviewed

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
     //zz, should have a simple comment to explain what is the return int mean
	 //@return, -1 means not balanced
	//          >=0 means the height of the tree	 
	 public int helper(TreeNode root){
		 if(root==null){
			 return 0;
		 }
		 int left=helper(root.left);//zz, leftRes
		 int right=helper(root.right);//zz, right Res
		 if(left==-1 || right==-1){
			 return -1;
		 }
		 if(Math.abs(left-right)>1){
			 return -1;
		 }
		 return Math.max(left, right)+1;
	 }
}
