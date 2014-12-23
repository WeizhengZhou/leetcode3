package additional;

public class TreeDiameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int diameter=0;
	public int getDiameter(TreeNode root){
		dfs(root);
		return diameter;
	}
	
	public int dfs(TreeNode root){
		if(root==null){
			return 0;
		}
		int left=dfs(root.left);
		int right=dfs(root.right);
		diameter=Math.max(diameter, left+right+1);
		return Math.max(left, right)+1;
	}
}
