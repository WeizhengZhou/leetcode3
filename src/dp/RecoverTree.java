package dp;

public class RecoverTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TreeNode small=null;
	TreeNode large=null;
	
	public void recoverTree(TreeNode root){
		if(root==null){
			return;
		}
		helper(root);
		int temp=small.val;
		small.val=large.val;
		large.val=temp;
	}
	
	TreeNode prepre=null;
	TreeNode pre=null;
	
	public void helper(TreeNode root){
		if (root==null && pre!=null&&prepre!=null&&pre.val<prepre.val){
			small=pre;
			if(large==null){
				large=prepre;
			}
		}
		if(root==null){
			return;
		}
		helper(root.left);
		prepre=pre;
		pre=root;
		if (prepre==null && pre!=null && root!=null && pre.val>root.val){
			large=pre;
			if(small==null){
				small=root;
			}
		}
		if (pre!=null&&prepre!=null&&root!=null){
			if(pre.val<root.val&&pre.val<prepre.val){
				small=pre;
			}
			if(pre.val>root.val&&pre.val>prepre.val){
				large=pre;
			}
		}
		helper(root.right);
	}

}
