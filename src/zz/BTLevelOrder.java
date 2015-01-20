
//zz reviewd
package zz;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(root==null){
			return res;
		}
		Queue<TreeNode> current=new LinkedList<TreeNode>();//zz, renamed to curLevel
		Queue<TreeNode> next=new LinkedList<TreeNode>();//zz, renamed to nextLevel
		List<Integer> list=new LinkedList<Integer>();//zz, renamed to levelResBuf
		current.add(root);
		while(!current.isEmpty()){
			TreeNode node=current.poll();//zz, queue support two sets of methods, add with remove, offer with poll, you should be consistant
			list.add(node.val);
			if(node.left!=null){
				next.add(node.left);
			}
			if(node.right!=null){
				next.add(node.right);
			}
			if(current.isEmpty()){
				current=new LinkedList<TreeNode>(next);
				next.clear();
				res.add(new LinkedList<Integer>(list));
				list.clear();
			}
		}
		return res;
		
	}

}
