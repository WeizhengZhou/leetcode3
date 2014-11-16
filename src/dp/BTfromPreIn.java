package dp;

import java.util.HashMap;
import java.util.Map;

public class BTfromPreIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null ||inorder==null){
        	return null;
        }
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i=0; i<inorder.length;i++){
        	map.put(inorder[i], i);
        }
        return helper(map,preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode helper(Map<Integer,Integer> map,int [] pre, int preL, int preR, int[] in, int inL, int inR){
    	if (preR-preL!=inR-inL){
    		return null;
    	}
    	if (preL>preR||preL<0||preR>=pre.length||inL<0||inR>in.length){
    		return null;
    	}
    	if (preL==preR){
    		return new TreeNode(pre[preL]);
    	}
    	TreeNode root=new TreeNode(pre[preL]);
    	int i=map.get(pre[preL]);
    	root.left=helper(map,pre,preL+1,preL+i-inL,in,inL,i-1);
    	root.right=helper(map,pre,preL+1+i-inL,preR,in,i+1,inR);
    	return root;
    }

}
