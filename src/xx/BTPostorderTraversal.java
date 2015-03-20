package xx;

public class BTPostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        if(root==null) {return res;}
        TreeNode cur=root;
        TreeNode last=null;
        Stack<TreeNode> stack=new Stack<>();
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else{
                TreeNode top=stack.peek();
                if(top.right!=null && top.right!=last){
                    cur=top.right;
                }
                else{
                    last=stack.pop();
                    res.add(last.val);
                }
            }
        }
        return res;
    }
}
