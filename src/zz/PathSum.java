package zz;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//boolean flag;
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null){
			return false;
		}
		return helper(root,sum,0);
		//return flag;
	}
	
	public boolean helper(TreeNode root, int sum, int currentSum){
		if(root==null){
			return false;
		}
		if(root.left==null && root.right==null){
			if(currentSum+root.val==sum){
				return true;
			}
			return false;
		}
		if(helper(root.left,sum,currentSum+root.val))
			return true;
		return helper(root.right,sum,currentSum+root.val);
	}

}
