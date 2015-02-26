package xx;

public class SumRootLeafNumbers {
	int sum=0;
	public int sumNumbers(TreeNode root){
		if(root==null){return 0;}
		dfsHelper(root,0);
		return sum;
	}
	private void dfsHelper(TreeNode root,int preSum){
	    if(root==null)return;
	    int curSum=preSum*10+root.val;
	    if(root.left==null && root.right==null) sum+=curSum;
	    dfsHelper(root.left,curSum);
	    dfsHelper(root.right,curSum);
	}
}
