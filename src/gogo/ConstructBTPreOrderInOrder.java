package gogo;

import java.util.Arrays;

public class ConstructBTPreOrderInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (
        	preorder == null || inorder ==null || preorder.length ==0 || inorder.length ==0 || 
        	preorder.length != inorder.length
        ) return null;
        return helper(preorder,inorder);
    }
    
    private TreeNode helper(int[] pre, int[] in) {
    	if (pre==null || pre.length==0) return null;
    	TreeNode root = new TreeNode(pre[0]);
    	if (pre.length == 1) return root;
    	int index = -1;
    	for (int i=0;i<=in.length;i++) {
    		if (in[i]==pre[0]) {
    			index = i;
    			break;
    		}
    	}
    	if (index<0) return root;
    	int leftLen = index;
    	//int rightLen = in.length - index - 1;
    	int[] left = Arrays.copyOfRange(pre, 1, 1+leftLen);
    	int[] right = Arrays.copyOfRange(pre, 1+leftLen, pre.length);
    	root.left = helper(left,Arrays.copyOfRange(in, 0, index));
    	root.right = helper(right,Arrays.copyOfRange(in, index+1, in.length));
    	return root;
    }
}
