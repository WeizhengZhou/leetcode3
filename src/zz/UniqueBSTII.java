//zz reviewed

package zz;

import java.util.LinkedList;
import java.util.List;

public class UniqueBSTII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res=new LinkedList<TreeNode>();
		if(n<0){
			return res;
		}
		return helper(1,n);
	}
	
	public List<TreeNode> helper(int l, int r){
		List<TreeNode> res=new LinkedList<TreeNode>();
		if(l>r){
			res.add(null);
			return res;
		}
		if(l==r){			
			res.add(new TreeNode(l));
			return res;
		}
		for(int i=l;i<=r;i++){
			List<TreeNode> left=helper(l,i-1);
			List<TreeNode> right=helper(i+1,r);
			
			for(TreeNode leftNode:left){
				for(TreeNode rightNode:right){
					TreeNode root=new TreeNode(i);
					root.left=leftNode;
					root.right=rightNode;
					res.add(root);
				}
			}
		}
		return res;
	}

}
