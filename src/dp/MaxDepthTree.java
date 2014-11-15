package dp;

public class MaxDepthTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int depth=0;
    public int maxDepth(TreeNode root) {
        if(root==null){
        	return 0;
        }
        helper(root,0);
        return depth;
    }
    
    public void helper(TreeNode r, int d){
    	if (r==null){
    		return;
    	}
    	d++;
    	if(r.left==null&&r.right==null){
    		depth=Math.max(depth, d);

    	}
    	helper(r.left,d);
    	helper(r.right,d);
    }

}
