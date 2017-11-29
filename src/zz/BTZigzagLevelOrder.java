
//zz reviewed
package zz;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BTZigzagLevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<> ();
		s.add(1);
		s.add(2);
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		 List<List<Integer>> res=new LinkedList<List<Integer>>();
		 if(root==null){
			 return res;
		 }
		 Stack<TreeNode> current=new Stack<TreeNode>();//zz, current->curLevel
		 Stack<TreeNode> next=new Stack<TreeNode>();//zz, next->nextLevel
		 current.add(root);
		 List<Integer> list=new LinkedList<Integer>();
		 boolean left=true;//zz, left renamed to isLeftFirst
						   //zz, this simple "left" means a lot of things, you should make it more readable
						   //
						   //zz, boolean type is indicated as is***
						   //
		 while(!current.isEmpty()){
			 TreeNode node=current.pop();
			 list.add(node.val);
			 if(left){//zz, if(isLeftFirst)
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
