package dp;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
    	if (root==null){
    		return res;
    	}
    	Queue<TreeNode> cur=new LinkedList<TreeNode>();
    	Queue<TreeNode> next=new LinkedList<TreeNode>();
    	List<Integer> list=new LinkedList<Integer>();
    	cur.add(root);
    	while(!cur.isEmpty()){
    		TreeNode n=cur.remove();
    		list.add(n.val);
    		if(n.left!=null){
    			next.add(n.left);
    		}
    		if(n.right!=null){
    			next.add(n.right);
    		}
    		if(cur.isEmpty()){
    			res.addFirst(new LinkedList<Integer>(list));
    			list.clear();
    			cur=new LinkedList<TreeNode>(next);
    			next.clear();
    		}
    	}
    	return res;
    }

}
