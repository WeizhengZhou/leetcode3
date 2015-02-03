//zz reviewed
package zz;

public class ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isValidBST(TreeNode root){
		if(root==null){
			return true;
		}
		return helper(root,Long.MAX_VALUE,Long.MIN_VALUE);
	}
	
	public boolean helper(TreeNode root, long max, long min){//zz root,min,max more reasonable
		if(root==null){
			return true;
		}
		if(root.val>max || root.val<min){
			return false;
		}
		return helper(root.left,root.val,min) && helper(root.right,max,root.val);
		
	}

}
