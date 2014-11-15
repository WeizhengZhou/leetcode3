package dp;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root==null){
			return false;
		}
		return helper(root,0,sum);
    }
	
	public boolean helper(TreeNode r, int pre, int sum){
		if (r==null){
			return false;
		}
		if(r.left==null&&r.right==null){
			pre+=r.val;
			if (pre==sum){
				return true;
			}
			return false;
		}
		return helper(r.left,pre+r.val,sum)||helper(r.right,pre+r.val,sum);

	}
}
