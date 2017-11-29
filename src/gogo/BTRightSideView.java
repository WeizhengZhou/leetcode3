package gogo;

import java.util.LinkedList;
import java.util.List;

public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<> ();
        if (root==null) return list;
        List<TreeNode> cur = new LinkedList<> ();
        cur.add(root);
        while(!cur.isEmpty()) {
        	list.add(cur.get(cur.size()-1).val);
        	List<TreeNode> next=new LinkedList<> ();
        	for(TreeNode node:cur){
        		if (node.left!=null)next.add(node.left);
        		if (node.right!=null)next.add(node.right);
        	}
        	cur=next;
        }
        return list;
    }
}
