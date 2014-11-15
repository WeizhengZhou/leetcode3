package dp;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> PathSum(TreeNode root, int sum) {
		if (root==null){
			return new LinkedList<List<Integer>>();
		}
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		helper(root,0,sum,res,new LinkedList<Integer>());
		return res;
    }
	
	public void helper(TreeNode r, int pre, int sum, List<List<Integer>> res, List<Integer> list){
		if (r==null){
			return;
		}
		list.add(r.val);
		if(r.left==null&&r.right==null){
			pre+=r.val;
			if (pre==sum){
				res.add(new LinkedList<Integer>(list));
			}
		}		
		helper(r.left,pre+r.val,sum,res,list);
		helper(r.right,pre+r.val,sum,res,list);
		list.remove(list.size()-1);

	}

}
