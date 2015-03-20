package xx;
import java.util.*;
public class ValidBST {
	public boolean isValidBST(TreeNode root){
		if(root==null){return true;}
		Long pre=Long.MIN_VALUE;
		TreeNode cur=root;
		Stack<TreeNode> stack=new Stack<>();
		while(cur!=null || !stack.isEmpty()){
			if(cur!=null){
				stack.push(cur);
				cur=cur.left;
			}
			else{
				TreeNode top=stack.pop();
				if(top.val<=pre)return false;
				pre=(long)top.val;
				cur=top.right;
			}
		}
		return true;
		//return helper(root);
	}
	Long last=Long.MIN_VALUE;
	private boolean helper(TreeNode root){
		if(root==null)return true;
		if(!helper(root.left))return false;
		//if(root.val<=pre)return false;
		//pre=(long)root.val;
		return helper(root.right);
	}

}
