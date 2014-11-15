package dp;

public class PathNumSum {
	int sum=0;
	public int sumNumbers(TreeNode root){
		if(root==null){
			return 0;
		}
		helper(root,0);
		return sum;
	}
	public void helper(TreeNode root,int preSum){
		if(root==null){
			return;
		}
		if(root.left==null&&root.right==null){
			preSum=10*preSum+root.val;
			sum+=preSum;
			return;
		}
		helper(root.left,preSum*10+root.val);
		helper(root.right,preSum*10+root.val);
	}

}
