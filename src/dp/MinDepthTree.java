package dp;

public class MinDepthTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r=new TreeNode(1);
		r.right=new TreeNode(2);
		MinDepthTree m=new MinDepthTree();
		System.out.println(m.minDepth(r));

	}
	int depth=0;
    public int minDepth(TreeNode root) {
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
    		depth=depth==0?d:Math.min(depth, d);

    	}
    	helper(r.left,d);
    	helper(r.right,d);
    }

}
