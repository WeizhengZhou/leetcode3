package xx;

public class BTLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null){return res;}
        Queue<TreeNode> curLevel=new LinkedList<>();
        curLevel.add(root);
        Queue<Integer> resBuf=new LinkedList<>();
        Queue<TreeNode> nextLevel=new LinkedList<>();
        while(!curLevel.isEmpty()){
            TreeNode node=curLevel.poll();
            resBuf.add(node.val);
            if(node.left!=null){nextLevel.add(node.left);}
            if(node.right!=null){nextLevel.add(node.right);}
            if(curLevel.isEmpty()){
                res.add(new LinkedList<Integer>(resBuf));
                resBuf.clear();
                curLevel=new LinkedList<TreeNode>(nextLevel);
                nextLevel.clear();
            }
        }
        return res;
    }
}
