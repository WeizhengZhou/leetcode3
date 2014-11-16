package dp;

import java.util.HashMap;
import java.util.Map;

public class BTfromInPost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder==null ||inorder==null){
        	return null;
        }
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i=0; i<inorder.length;i++){
        	map.put(inorder[i], i);
        }
        return helper(map,postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode helper(Map<Integer,Integer> map,int [] post, int postL, int postR, int[] in, int inL, int inR){
    	if (postR-postL!=inR-inL){
    		return null;
    	}
    	if (postL>postR||postL<0||postR>=post.length||inL<0||inR>in.length){
    		return null;
    	}
    	if (postL==postR){
    		return new TreeNode(post[postR]);
    	}
    	TreeNode root=new TreeNode(post[postR]);
    	int i=map.get(post[postR]);
    	root.left=helper(map,post,postL,postL+i-inL-1,in,inL,i-1);
    	root.right=helper(map,post,postL+i-inL,postR-1,in,i+1,inR);
    	return root;
    }
}
