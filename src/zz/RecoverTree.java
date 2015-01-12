package zz;

public class RecoverTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	TreeNode large;
	TreeNode small;
	TreeNode prepre=null;
	TreeNode pre=null;
	TreeNode cur=null;
	public void recoverTree(TreeNode root){
		if(root==null){
			return;
		}
		helper(root);
		int temp=large.val;
		large.val=small.val;
		small.val=temp;
	}
	
	public void helper(TreeNode root){
		if(root==null && prepre!=null && pre!=null && prepre.val>pre.val){
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
		//cur=root;
		if(prepre==null && pre!=null && cur!=null && pre.val>cur.val){
			large=pre;
			if(small==null){
				small=cur;
			}
		}
		if(prepre!=null && pre!=null && cur!=null){
			if(pre.val>prepre.val && pre.val>cur.val){
				large=pre;
			}
			if(pre.val<prepre.val && pre.val<cur.val){
				small=pre;
			}
		}
		helper(root.right);
	}

}
