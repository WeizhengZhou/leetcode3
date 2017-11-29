package gogo;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> list = new LinkedList<> ();
    	if (root==null) return list;
    	helper(new LinkedList<Integer> (), root, sum, list);
    	return list;
    }
    private void helper(List<Integer> buffer, TreeNode root, int sum, List<List<Integer>> list) {
    	buffer.add(root.val);
    	if (root.left==null && root.right==null && sum==root.val) {
    		list.add(new LinkedList<Integer>(buffer));
    		buffer.remove(buffer.size()-1);
    		return;
    	}
    	if (root.left!=null) {
    		helper(buffer, root.left, sum-root.val, list);
    	}
    	if (root.right != null) {
    		helper(buffer,root.right,sum-root.val,list);
    	}	
    	buffer.remove(buffer.size()-1);
    }
}
