package gogo;

import java.util.LinkedList;
import java.util.List;

public class RecoverTree {
	public static void main(String[] args) {
		RecoverTree r = new RecoverTree();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		r.recoverTree(root);
	}
	TreeNode first = null;
	TreeNode second = null;
	TreeNode large = null;
	TreeNode small = null;
	//TreeNode cur = null;
    public void recoverTree(TreeNode root) {
        if (root==null) return;
        List<TreeNode> list = new LinkedList<> ();
        helper(root,list);
        if (second!=null && first!=null && second.val<first.val) {
			//list.add(second);//System.out.println("cur===null,first="+first.val+",second="+second.val);
			small=second;
			if (large==null) large = first;
		}
       // if (list.size()<2) return;
        
        for (int i=0;i<list.size();i++) {
        	//System.out.println(list.get(i).val);
        }
        int temp = large.val;
        large.val = small.val;
        small.val = temp;
    }
    private void helper(TreeNode cur, List<TreeNode> list) {
    	if (cur==null) {
    		return;
    	}
    	helper(cur.left,list);
    	if (first==null && second !=null && second.val>cur.val || first!=null && second!=null && second.val>first.val && second.val>cur.val && large==null) {
    		large=second;//System.out.println("large,cur="+cur.val+",second="+second.val);
    	} 
    	if (first !=null && second!=null && first.val>second.val && second.val<cur.val ) {
    		small=second;//System.out.println("small,cur="+cur.val+",second="+",second="+second.val);
    	}	
    	first = second;
    	second = cur;
    	helper(cur.right,list);
    	
    }
}
