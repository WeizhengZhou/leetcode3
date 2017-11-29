package gogo;

import java.util.LinkedList;
import java.util.List;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
 }
public class BSInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<> ();
        if (root==null) return list;
        helper(root,list);
        return list;
    }
    private void helper(TreeNode root, List<Integer> list) {
    	if (root == null) return;
    	helper(root.left,list);
    	list.add(root.val);
    	helper(root.right,list);
    }
}
