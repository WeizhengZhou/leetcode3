package gogo;

import java.util.LinkedList;
import java.util.List;

public class BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> list = new LinkedList<> ();
    	if (root==null) return list;
    	List<TreeNode> curLevel = new LinkedList<> ();
    	curLevel.add(root);
    	while (!curLevel.isEmpty()) {
    		List<TreeNode> nextLevel = new LinkedList<> ();
    		List<Integer> cur = new LinkedList<> ();
    		for (TreeNode node:curLevel) {
    			cur.add(node.val);
    			if (node.left != null) nextLevel.add(node.left);
    			if (node.right !=null) nextLevel.add(node.right);
    		}
    		list.add(cur);
    		curLevel = nextLevel;
    	}
    	return list;
    }
}
