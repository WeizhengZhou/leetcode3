package gogo;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<> ();
        if (root==null) return list;
        helper(root,"",list);
        return list;
    }
    private void helper(TreeNode root, String s,List<String> list) {
    	StringBuilder sb=new StringBuilder(s);
    	if (s=="") {
    		sb.append(root.val);
    	} else {
    		sb.append("->"+root.val);
    	}
    	if (root.left!=null) {
    		helper(root.left,sb.toString(),list);
    	}
    	if (root.right!=null) {
    		helper(root.right,sb.toString(),list);
    	}
    	if (root.left==null && root.right==null) {
    		list.add(sb.toString());
    	}
    }
}
