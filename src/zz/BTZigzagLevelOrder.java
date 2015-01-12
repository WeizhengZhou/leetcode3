package zz;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BTZigzagLevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		 List<List<Integer>> res=new LinkedList<List<Integer>>();
		 if(root==null){
			 return res;
		 }
		 Stack<TreeNode> current=new Stack<TreeNode>();
		 Stack<TreeNode> next=new Stack<TreeNode>();
		 current.add(root);
		 List<Integer> list=new LinkedList<Integer>();
		 boolean left=true;
		 while(!current.isEmpty()){
			 TreeNode node=current.pop();
			 list.add(node.val);
			 if(left){
				 if(node.left!=null){
					 next.add(node.left);
				 }
				 if(node.right!=null){
					 next.add(node.right);
				 }
			 }
			 else{
				 if(node.right!=null){
					 next.add(node.right);
				 }
				 if(node.left!=null){
					 next.add(node.left);
				 }				 
			 }
			 if(current.isEmpty()){
				 res.add(new LinkedList<Integer>(list));
				 list.clear();
				 current=next;
				 next=new Stack<TreeNode>();
				 left=!left;
			 }
		 }
		 return res;
	 }

}
