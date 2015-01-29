//zz reviewed
package zz;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r=new TreeNode(2);
		r.right=new TreeNode(3);
		r.left=new TreeNode(1);
		PostOrderIterate p=new PostOrderIterate();
		System.out.println(p.postorderTraversal(r).toString());

	}
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res=new LinkedList<Integer>();
		if(root==null){
			return res;
		}
		TreeNode current=root;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode last=null;
		while(current!=null || !stack.isEmpty()){
			if(current!=null){
				stack.push(current);
				current=current.left;
			}
			else{
				TreeNode top=stack.peek();
				//System.out.println("last="+last.val+" , top="+top.val);
				if(top.right!=null && last!=top.right){
					current=top.right;
					System.out.println("current="+current);
				}
				else{
					res.add(stack.pop().val);
					last=top;
					System.out.println("last="+last.val+" , top="+top.val);
				}
			}
		}
		return res;
	}
}
