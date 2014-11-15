package dp;

public class ValidBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r=new TreeNode(10);
		r.left=new TreeNode(5);
		TreeNode right=new TreeNode(15);
		r.right=right;
		right.left=new TreeNode(9);
		right.right=new TreeNode(16);
		ValidBST v=new ValidBST();
		System.out.println(v.isValidBST(r));

	}
		
	public boolean isValidBST(TreeNode root){
		if(root==null){
			return true;
		}
		return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);	
	}
	
	public boolean helper(TreeNode r, int min, int max){
		if(r==null){
			return true;
		}		
		if(r.val<=min||r.val>=max){
				return false;
		}	
		System.out.println(r.val);
		System.out.println(min);
		System.out.println(max);
		System.out.println("");
		return helper(r.left,min,r.val)&&helper(r.right,r.val,max);
	}
}

