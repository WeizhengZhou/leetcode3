package xx;

import java.util.Stack;

public class BSTIterator {
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
	    if(hasNext()){
        TreeNode next=s.pop();
        push(next.right);
        return next.val;
	    }
	    else{
	        throw new NullPointerException();
	    }
	 }
}
