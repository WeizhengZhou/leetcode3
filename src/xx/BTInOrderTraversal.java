package xx;

public class BTInOrderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        if(root==null)return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else{
                TreeNode top=stack.pop();
                res.add(top.val);
                cur=top.right;
            }
        }
        return res;
    }
}
