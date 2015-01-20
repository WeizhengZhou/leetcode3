
//zz reviewd
package zz;

import java.util.HashMap;
import java.util.Map;

public class BSTInOrderPostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTInOrderPostOrder b=new BSTInOrderPostOrder();
		b.buildTree(new int[]{1,3,2}, new int[]{3,2,1});

	}

    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder==null || postorder==null || inorder.length==0 || inorder.length!=postorder.length){
    		return null;
    	}
		//zz, if the tree has duplicates, this method will fail
		//zz, consider given inorder = {1,1}, postorder = {1,1}
		//zz, the hashmap will only have one element, however ~~~
    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    	for(int i=0;i<inorder.length;i++){
    		map.put(inorder[i], i);
    	}
    	return helper(0,inorder.length-1,inorder,0,postorder.length-1,postorder,map);
    }
    
    public TreeNode helper(int inLeft, int inRight, int[] inorder, int postLeft, int postRight, int[] postorder, Map<Integer, Integer> map){
        
    	if(inLeft>inRight || postLeft>postRight){
    		return null;
    	}
		//zz, should check if(inRight-inLeft == postRight-postLeft)
    	if(inLeft==inRight){
    		return new TreeNode(inorder[inLeft]);//zz before you call inorder[inLeft], you should check if inLeft out of boundary
    	}
    	TreeNode root=new TreeNode(postorder[postRight]);
    	int index=map.get(postorder[postRight]);//zz, index renamed to rootIndex
    	int postLeftLength=index-inLeft;//zz, postLeftLength renamed to postLeftSubTreeLength
    	int postRightLength=inRight-index;
    	//System.out.println("index="+index+",postleftLen="+postLeftLength+",postRightLen="+postRightLength);
    	//System.out.println("inLeft="+inLeft+",inright="+inRight);
    	//System.out.println("postLeft="+postLeft+",postright="+postRight);
    	root.left=helper(inLeft,index-1,inorder,postLeft,postLeft+postLeftLength-1,postorder,map);
    	root.right=helper(index+1,inRight,inorder,postRight-postRightLength,postRight-1,postorder,map);
    	return root;
    }
}
