//zz reviewed
package zz;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p==null && q==null){
			return true;
		}
		if(p==null || q==null){//zz else if
			return false;
		}
		if(p.val!=q.val){//zz else if
			return false;
		}
		//zz else
		return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
	}
}
