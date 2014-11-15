package dp;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSymTree(TreeNode root){
		if(root==null){
			return true;
		}
		return helper(root.left,root.right);
	}
	
	public boolean helper(TreeNode n1, TreeNode n2){
		if(n1==null&&n2==null){
			return true;
		}
		if(n1==null||n2==null){
			return false;
		}
		if(n1.val!=n2.val){
			return false;
		}
		return helper(n1.left,n2.right)&&helper(n1.right,n2.left);
	}

}
