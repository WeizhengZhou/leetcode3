package zz;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res=new LinkedList<Integer>();
		if(root==null){
			return res;
		}
		TreeNode cur=root;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		while(cur!=null || !stack.isEmpty()){
			if(cur!=null){
				res.add(cur.val);
				stack.push(cur);
				cur=cur.left;
			}
			else{
				cur=stack.pop().right;
			}
		}
		return res;
	}

}
