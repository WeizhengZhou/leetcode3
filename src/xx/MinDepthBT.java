package xx;

public class MinDepthBT {
	public int minDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		return helper(root);
	}
	
	public int helper(TreeNode root){
		if(root.left==null && root.right==null){
			return 1;
		}
		int min=Integer.MAX_VALUE;
		if(root.left!=null){
			min=Math.min(helper(root.left), min);
		}
		if(root.right!=null){
			min=Math.min(helper(root.right), min);
		}
		return min+1;
	}
}
