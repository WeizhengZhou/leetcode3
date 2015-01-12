package zz;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p==null && q==null){
			return true;
		}
		if(p==null || q==null){
			return false;
		}
		if(p.val!=q.val){
			return false;
		}
		return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
	}
}
