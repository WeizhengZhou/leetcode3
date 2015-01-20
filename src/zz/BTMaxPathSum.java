
//zz reviewed
package zz;

public class BTMaxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t=new TreeNode(0);
		BTMaxPathSum b=new BTMaxPathSum();
		System.out.println(b.maxPathSum(t));

	}
	int max=Integer.MIN_VALUE;//zz renamed to maxPathSum
	public int maxPathSum(TreeNode root) {
		if(root==null){
			return 0;
		}
		helper(root);
		return max;
	}
	
	//
	public int helper(TreeNode root){
		if(root==null){
			return 0;
		}
		int left=helper(root.left);//zz, renamed to leftOneWaySum
		int right=helper(root.right);//zz, renamed to rightOneWaySum
		//zz, this two lines are a little complicated, 
		//zz, each line contain too much information,
		//zz, you should make it easier to read
		//zz, for example,
		//int maxOneWaySum = Math.max(leftOneWaySum,rightOneWaySum) + root.val; 
		//maxOneWaySum = Math.max(maxOneWaySum,root.val);
		//int twoWaySum = Math.max(leftOneWaySum+rightOneWaySum+root.val);
		//max = Math.max(max,twoWaySum);
		//return maxOneWaySum;
		int pathSum=Math.max(Math.max(left, right)+root.val, root.val);
		max=Math.max(max, Math.max(pathSum, left+right+root.val));
		return pathSum;
	}
}
