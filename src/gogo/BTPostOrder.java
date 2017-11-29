package gogo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BTPostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<> ();
        if (root==null) return list;
        Stack<TreeNode> s = new Stack<> ();
        s.push(root);
        while(!s.isEmpty()) {
        	TreeNode top = s.peek();
        	int last = list.isEmpty() ? -1 : list.get(list.size()-1);
        	if (top.left==null && top.right == null) {
        		list.add(top.val);
        		s.pop();
        	} else if (top.left==null){
        		if (last!=top.right.val) {
        			s.push(top.right);
        		} else {
        			list.add(top.val);
            		s.pop();
        		}
        	} else if (top.right == null) {
        		if (last!=top.left.val) {
        			s.push(top.left);
        		} else {
        			list.add(top.val);
            		s.pop();
        		}
        	} else {
        		if (last!=top.right.val) {
        			s.push(top.right);
        		} else {
        			list.add(top.val);
            		s.pop();
        		}
        	}
        }
        return list;
    }
}
