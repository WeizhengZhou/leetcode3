package xx;

public class SymmetricTree {
	 public boolean isSymmetric(TreeNode root) {
		 if(root==null)return true;
		 return helper(root.left,root.right);
	 }
	 private boolean helper(TreeNode node1,TreeNode node2){
	     if(node1==null && node2==null){return true;}
	     if(node1==null || node2==null){return false;}
	     if(node1.val!=node2.val){return false;}
	     return helper(node1.left,node2.right) && helper(node1.right,node2.left);
	 }
}
