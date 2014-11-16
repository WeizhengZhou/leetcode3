package dp;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res=new LinkedList<Integer>();
    	if (root==null){
        	return res;
        }
        
        TreeNode cur=root;
        TreeNode last=null;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(cur!=null||!stack.isEmpty()){
        	if(cur!=null){
        		stack.push(cur);
        		cur=cur.left;
        	}
        	else{
        		TreeNode nd=stack.peek();
        		if (nd.right!=null && nd.right!=last){
        			cur=nd.right;
        		}
        		else
        		{
        			res.add(nd.val);
        			TreeNode n=stack.pop();
        			last=n;
        		}
        	}
        }
        return res;
    }
}
