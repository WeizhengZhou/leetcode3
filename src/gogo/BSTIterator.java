package gogo;

import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
    	s = new Stack<> ();
    	push(root);
    }
    private void push(TreeNode node) {
    	while(node!=null) {
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
        TreeNode node=s.pop();
        push(node.right);
        return node.val;
    }
}
