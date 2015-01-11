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
	
	public int helper(TreeNode root,int preDep){
		if(root.left==null && root.right==null){
			return preDep+1;
		}
		preDep++;
		int min=Integer.MAX_VALUE;
		if(root.left!=null){
			min=Math.min(helper(root.left,preDep), min);
		}
		if(root.right!=null){
			min=Math.min(helper(root.right,preDep), min);
		}
		return min;
	}

}
