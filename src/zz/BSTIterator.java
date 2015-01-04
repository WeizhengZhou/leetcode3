package zz;

import java.util.Stack;

public class BSTIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(3);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(4);
		root.right=new TreeNode(7);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(8);
		BSTIterator b=new BSTIterator(root);
		while(b.hasNext()){
			System.out.println(b.next());
		}
	}
	
	Stack<TreeNode> s=new Stack<TreeNode>();
	
	 public BSTIterator(TreeNode root) {
	      push(root);  
	 }
	 
	 public void push(TreeNode node){
		 while(node!=null){
			 s.push(node);
			 node=node.left;
		 }
	 }

	    /** @return whether we have a next smallest number */
	 public boolean hasNext() {
	       return !s.isEmpty(); 
	 }

	    /** @return the next smallest number */
	 public int next() {
	        TreeNode top=s.pop();
	        if(top.right!=null){
	        	push(top.right);
	        }
	        return top.val;
	 }

}
