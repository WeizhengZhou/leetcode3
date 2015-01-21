
//zz reviewed

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
//zz try iterative solution	
	public TreeNode helper(TreeNode root){
		if(root==null){
			return null;
		}
		TreeNode left=helper(root.left);
		TreeNode right=helper(root.right);
		root.left=null;
		if(left!=null){
			root.right=left;
			while(left.right!=null){//zz, in each call of helper, log(n) is spent in this loop
									//zz, O(n) calls of helper lead to O(nlog(n)) time.
									//zz, you can create a heler class called Result to store the head and tail of the flatten list 
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
