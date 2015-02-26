package xx;

public class BTPreorderTraversal {
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
