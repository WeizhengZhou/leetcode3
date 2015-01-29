//zz reviewed
package zz;

public class MinDepthBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		return helper(root,0);
	}
	
	public int helper(TreeNode root,int preDep){//zz depth is enough
		//zz check root == null, for each method with treenode passing in
		if(root.left==null && root.right==null){
			return preDep+1;
		}
		preDep++;
		int min=Integer.MAX_VALUE;//zz minDepth
		if(root.left!=null){
			min=Math.min(helper(root.left,preDep), min);
		}
		if(root.right!=null){
			min=Math.min(helper(root.right,preDep), min);
		}
		return min;
		/*
			int minDepth = depth+1;//root.left == null && root.right == null
			if(root.left != null){
				minDepth = Math.min(minDepth,helper(root.left,depth+1));	
			}
			if(root.right != null){
				minDepth = Math.min(minDepth,helper(root.right,depth+1));	
			}
			return minDepth;	
		*/
	}

}
