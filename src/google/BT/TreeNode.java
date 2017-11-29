package BT;

public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
	public String toString(){
		return inorder(this);
	}
	private String inorder(TreeNode root){
		if(root == null) return "";
		String left = inorder(root.left);
		String right = inorder(root.right);
		return left +  ", "+ root.val + ", " + right;
	}
}