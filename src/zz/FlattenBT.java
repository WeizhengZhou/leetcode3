package zz;

public class FlattenBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void flatten(TreeNode root) {
		if(root==null){
			return; 
		}
		helper(root);
	}
	
	public TreeNode helper(TreeNode root){
		if(root==null){
			return null;
		}
		TreeNode left=helper(root.left);
		TreeNode right=helper(root.right);
		root.left=null;
		if(left!=null){
			root.right=left;
			while(left.right!=null){
				left=left.right;
			}
			left.right=right;
		}
		else{
			root.right=right;
		}
		return root;
	}
}
