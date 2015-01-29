//zz reviewed

package zz;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(root==null){
			return res;
		}
		helper(root,sum,0,new LinkedList<Integer>(),res);
		return res;
	}
	//zz this preSum can be eliminated
	//zz if sum is deducted when passing from root to leaf	
	public void helper(TreeNode root, int sum, int preSum, List<Integer> list,List<List<Integer>> res){
		if(root==null){
			return;
		}
		if(root.left==null && root.right==null){
			if(preSum+root.val==sum){
				list.add(root.val);
				res.add(new LinkedList<Integer>(list));
				list.remove(list.size()-1);
				return;
			}
		}
		list.add(root.val);
		preSum+=root.val;
		helper(root.left,sum,preSum,list,res);
		helper(root.right,sum,preSum,list,res);
		list.remove(list.size()-1);
	}
}
