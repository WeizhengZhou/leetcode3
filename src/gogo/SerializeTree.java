package gogo;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    StringBuilder sb=new StringBuilder();
    Queue<TreeNode> q=new LinkedList<> ();
    if(root==null) return sb.toString();
    q.add(root);
    sb.append(root.val);
    while(!q.isEmpty()) {
    	TreeNode node=q.poll();
    	sb.append(',');
    	if (node.left!=null) {
    		q.add(node.left);
    		sb.append(node.left.val);
    	} else {
    		sb.append('n');
    	}
    	sb.append(',');
    	if (node.right!=null) {
    		q.add(node.right);
    		sb.append(node.right.val);
    	} else {
    		sb.append('n');
    	}
    }
    return sb.toString();
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    if (data==null || data.length()==0) return null;
    String[] ss=data.split(",");
    Queue<TreeNode> cur=new LinkedList<> ();
    if (ss[0].equals("n")) return null;
    TreeNode root=new TreeNode(Integer.parseInt(ss[0]));
    cur.add(root);
    int i=1;
    while(!cur.isEmpty()) {
    	Queue<TreeNode> next=new LinkedList<> ();
    	while(!cur.isEmpty()) {
    		TreeNode node=cur.poll();
    		String l=ss[i++];
    		TreeNode left=null;
    		if (!l.equals("n")) {
    			left=new TreeNode(Integer.parseInt(l));
    			next.add(left);
    			node.left=left;
    		}
    		String r=ss[i++];
    		TreeNode right=null;
    		if (!r.equals("n")) {
    			right=new TreeNode(Integer.parseInt(r));
    			next.add(right);
    			node.right=right;
    		}		
    	}
    	cur=next;
    }
    return root;
}
}
