package zz;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderButtom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		 LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
		 if(root==null){
			 return res;
		 }
		 Queue<TreeNode> currentLevel=new LinkedList<TreeNode>();
		 currentLevel.add(root);
		 Queue<Integer> level=new LinkedList<Integer>();
		 //level.add(root.val);
		 //res.add(new LinkedList<Integer>(level));
		 //level.clear();
		 Queue<TreeNode> nextLevel=new LinkedList<TreeNode>();
		 while(!currentLevel.isEmpty()){
			 TreeNode cur=currentLevel.poll();
			 level.add(cur.val);
			 if(cur.left!=null){
				 nextLevel.add(cur.left);
			 }
			 if(cur.right!=null){
				 nextLevel.add(cur.right);
			 }
			 if(currentLevel.isEmpty()){
				 res.addFirst(new LinkedList<Integer>(level));
				 level.clear();
				 currentLevel=new LinkedList<TreeNode>(nextLevel);
				 nextLevel.clear();
			 }
		 }
		 return res;
	 }

}
