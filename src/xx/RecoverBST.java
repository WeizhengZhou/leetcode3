package xx;

public class RecoverBST {
	TreeNode large;
    TreeNode small;
    TreeNode pre=new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root){
		if(root==null)return;
		traverse(root);
		int temp=large.val;
		large.val=small.val;
		small.val=temp;
	}
	private void traverse(TreeNode root){
	    if(root==null)return;
	    traverse(root.left);
	    if(large==null && root.val<pre.val){
	        large=pre;
	    }
	    if(large!=null && root.val<pre.val){
	        small=root;
	    }
	    pre=root;
	    traverse(root.right);
	}
}
