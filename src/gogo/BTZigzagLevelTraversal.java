package gogo;

import java.util.LinkedList;
import java.util.List;

public class BTZigzagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> list = new LinkedList<> ();
    	if (root==null) return list;
    	List<TreeNode> cur = new LinkedList<> ();
    	cur.add(root);
    	List<Integer> curValue = new LinkedList<> ();
    	curValue.add(root.val);
    	list.add(curValue);
    	boolean reverse = true;
    	while (!cur.isEmpty()) {
    		List<TreeNode> next = new LinkedList<> ();
    		List<Integer> value = new LinkedList<> ();
    		if (!reverse) {
    			for (int i=0;i<cur.size();i++) {
    				TreeNode node = cur.get(i);
    				if (node.left!=null) {
    					next.add(node.left);
    					value.add(node.left.val);
    				}
    				if (node.right!=null) {
    					next.add(node.right);
    					value.add(node.right.val);
    				}
    			}
    		} else {
    			for (int i=cur.size()-1;i>=0;i--) {
    				TreeNode node = cur.get(i);
    				if (node.right!=null) {
    					next.add(0,node.right);
    					value.add(node.right.val);
    				}
    				if (node.left!=null) {
    					next.add(0, node.left);
    					value.add(node.left.val);
    				}
    				
    			}
    		}
    		cur=next;
    		if (!value.isEmpty()) {
    			list.add(value);
    		}
    		reverse = !reverse;
    	}
    	return list;
    }
}
