package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniqueBSTII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBSTII u=new UniqueBSTII();
		List<TreeNode> l=u.generateTrees(0);
		System.out.println(l.size());

	}

	public List<TreeNode> generateTrees(int n){
		if(n==0) {
			List<TreeNode> t=new LinkedList<TreeNode>();
			t.add(null);
			return t;
		}
		return helper(1,n);
	}
	
	public List<TreeNode> helper(int l,int r){
		if (l>r) return new LinkedList<TreeNode>();
		if (l==r) {
			List<TreeNode> t=new LinkedList<TreeNode>();
			t.add(new TreeNode(l));
			return t;
		}
		List<TreeNode> res=new LinkedList<TreeNode>();
		for(int i=l;i<=r;i++){
			TreeNode root=new TreeNode(i);
			List<TreeNode> left=helper(l,i-1);
			List<TreeNode> right=helper(i+1,r);
			for(int ii=0;ii<Math.max(1, left.size());ii++){
				for(int jj=0;jj<Math.max(1, right.size());jj++){
					if(left.size()>0){
						root.left=left.get(ii);
					}
					if(right.size()>0){
						root.right=right.get(jj);
					}
					
					res.add(root);
				}
			}
		}
		return res;
	}
	
	private class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; left = null; right = null; }
		 }
}

