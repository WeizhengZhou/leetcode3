package zz;

import java.util.HashMap;
import java.util.Map;

public class BSTInOrderPreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder==null || inorder==null ||preorder.length==0|| preorder.length!=inorder.length){
			return null;
		}
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<inorder.length;i++){
			map.put(inorder[i],i);
		}
		return helper(0,preorder.length-1,preorder,0,inorder.length-1,inorder,map);
	}
	
	public TreeNode helper(int preLeft,int preRight,int[] preorder,int inLeft, int inRight, int[] inorder, Map<Integer,Integer> map){
		if(inLeft>inRight){
			return null;
		}
		if(preLeft==preRight){
			return new TreeNode(preorder[preLeft]);
		}
		TreeNode root=new TreeNode(preorder[preLeft]);
		int index=map.get(preorder[preLeft]);
		int preLeftLen=index-inLeft;
		int preRightLen=inRight-index;
		root.left=helper(preLeft+1,preLeft+preLeftLen,preorder,inLeft,index-1,inorder,map);
		root.right=helper(preRight-preRightLen+1,preRight,preorder,index+1,inRight,inorder,map);
		return root;
	}

}
