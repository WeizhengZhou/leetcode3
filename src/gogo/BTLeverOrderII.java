package gogo;

import java.util.LinkedList;
import java.util.List;

public class BTLeverOrderII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> list = new LinkedList<> ();
    	if (root==null) return list;
    	List<Integer> cur = new LinkedList<> ();
    	List<TreeNode> curLv = new LinkedList<> ();
    	curLv.add(root);
    	cur.clear();
    	while (!curLv.isEmpty()) {
    		List<TreeNode> next = new LinkedList<> ();
    		for (TreeNode node:curLv) {
    			cur.add(node.val);
    			if (node.left!=null){
    				next.add(node.left);
    			}
    			if (node.right!=null) next.add(node.right);
    		}
    		list.add(0,new LinkedList<> (cur));
    		cur.clear();
    		curLv = next;
    	}
    	return list;
    }
}
