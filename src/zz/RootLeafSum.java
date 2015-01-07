package zz;

public class RootLeafSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int sum=0;
	public int sumNumbers(TreeNode root){
		if(root==null){
			return 0;
		}
		dfs(root,0);
		return sum;
	}
	
	public void dfs(TreeNode root, int currentSum){
		if(root==null){			
			return;
		}
		currentSum=currentSum*10+root.val;
		if(root.left==null && root.right==null){
			sum+=currentSum;
			return;
		}		
		dfs(root.left,currentSum);
		dfs(root.right,currentSum);
	}

}
