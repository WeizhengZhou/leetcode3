package zz;

public class BTMaxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t=new TreeNode(0);
		BTMaxPathSum b=new BTMaxPathSum();
		System.out.println(b.maxPathSum(t));

	}
	int max=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if(root==null){
			return 0;
		}
		helper(root);
		return max;
	}
	
	public int helper(TreeNode root){
		if(root==null){
			return 0;
		}
		int left=helper(root.left);
		int right=helper(root.right);
		int pathSum=Math.max(Math.max(left, right)+root.val, root.val);
		max=Math.max(max, Math.max(pathSum, left+right+root.val));
		return pathSum;
	}
}
