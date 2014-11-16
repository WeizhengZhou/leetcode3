package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigzagTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null){
        	return null;
        }
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        List<Integer> list=new LinkedList<Integer>();
        Stack<TreeNode> cur=new Stack<TreeNode>();
        Stack<TreeNode> next=new Stack<TreeNode>();
        cur.push(root);
        boolean lToR=true;
        while(!cur.isEmpty()){
        	TreeNode r=cur.pop();
        	list.add(r.val);
        	if (lToR){
        		if(r.left!=null){
        			next.push(r.left);
        		}
        		if(r.right!=null){
        			next.push(r.right);
        		}
        	}
        	if (!lToR){
        		if(r.right!=null){
        			next.push(r.right);
        		}
        		if(r.left!=null){
        			next.push(r.left);
        		}
        	}
        	if (cur.isEmpty()){
        		cur=(Stack<TreeNode>)next.clone();
        		next.clear();
        		res.add(new LinkedList<Integer>(list));
        		list.clear();
        		lToR=!lToR;
        	}
        }
        return res;
    }

}
