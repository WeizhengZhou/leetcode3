//zz reviewed
package zz;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//zz, understand this algorithm
public class InOrderBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res=new LinkedList<Integer>();
		if(root==null){
			return res;
		}
		TreeNode current=root;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		while(current!=null || !stack.isEmpty()){
			if(current!=null){
				stack.push(current);
				current=current.left;
			}
			else{
				TreeNode top=stack.pop();
				res.add(top.val);
				current=top.right;
			}
		}
		return res;
	}

}
