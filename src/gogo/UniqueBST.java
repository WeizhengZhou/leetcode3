package gogo;

import java.util.LinkedList;
import java.util.List;

public class UniqueBST {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new LinkedList<> ();
        if (n<=0) return list;
        list = helper(1,n);
        return list;
    }
    
    private List<TreeNode> helper(int l, int r) {
    	List<TreeNode> list = new LinkedList<> ();
    	if(l>r) {
    		list.add(null);
    		return list;
    	}
    	for(int i=l;i<=r;i++) {
    		List<TreeNode> left = helper(l,i-1);
    		List<TreeNode> right = helper(i+1,r);
    		for (TreeNode leftNode: left) {
    			for(TreeNode rightNode: right) {
    				TreeNode t = new TreeNode(i);
    				t.left = leftNode;
    				t.right = rightNode;
    				list.add(t);
    			}
    		}
    	}
    	return list;
    }
}
