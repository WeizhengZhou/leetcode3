package bt;


public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){this.val = x;}
	
	private String preorder(TreeNode root){
		if(root != null){
			String s = "";
			s += root.val + ", ";
			s += preorder(root.left);
			s += preorder(root.right);
			return s;
		}
		else 
			return "";
	}
	public String toString(){
		return preorder(this);
		
	}

}
