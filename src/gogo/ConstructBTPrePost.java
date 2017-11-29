package gogo;

import java.util.Arrays;

public class ConstructBTPrePost {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (
        		inorder == null || postorder ==null || inorder.length ==0 || postorder.length ==0 || 
        				inorder.length != postorder.length
        ) return null;
        return helper(inorder,postorder);
    }
    
    private TreeNode helper(int[] in, int[] post) {
    	if (in==null || in.length == 0) return null;
    	TreeNode root = new TreeNode(post[post.length-1]);
    	if (in.length == 1) return root;
    	int index = -1;
    	for (int i=0;i<=post.length;i++) {
    		if (in[i]==root.val) {
    			index = i;
    			break;
    		}
    	}
    	if (index<0) return root;
    	int leftLen = index;
    	//int rightLen = in.length - index - 1;
    	int[] left = Arrays.copyOfRange(in, 0, leftLen);
    	int[] right = Arrays.copyOfRange(in, leftLen+1, in.length);
    	root.left = helper(left,Arrays.copyOfRange(post, 0, leftLen));
    	root.right = helper(right,Arrays.copyOfRange(post, leftLen, post.length-1));
    	return root;
    }
}
