package zz;

public class MaxDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int maxDepth(TreeNode root) {
		 if(root==null){
			 return 0;
		 }
		 return helper(root);
	 }
	 
	 public int helper(TreeNode root){
		 if(root==null){
			 return 0;
		 }
		 int left=helper(root.left);
		 int right=helper(root.right);
		 return Math.max(left, right)+1;
	 }

}
