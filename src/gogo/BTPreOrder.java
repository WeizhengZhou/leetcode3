package gogo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BTPreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list = new LinkedList<> ();
    	if (root==null) return list;
    	Stack<TreeNode> s=new Stack<> ();
    	s.add(root);
    	while(!s.isEmpty()) {
    		TreeNode cur = s.pop();
    		list.add(cur.val);
    		if (cur.right != null) {
    			s.push(cur.right);
    		}
    		if (cur.left!=null) {
    			s.push(cur.left);
    		}
    	}
    	return list;
    }
}
