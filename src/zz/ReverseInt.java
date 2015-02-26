//zz reviewed
package zz;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<Integer> l=new LinkedList<>();

	}
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
			LinkedList<List<Integer>> res=new LinkedList<>();
			if(root==null){return res;}
			Queue<TreeNode> curLevel=new LinkedList<>();
			List<TreeNode> nextLevel=new LinkedList<>();
			List<Integer> resBuf=new LinkedList<>();
			curLevel.add(root);
			while(!curLevel.isEmpty()){
			TreeNode curNode=curLevel.poll();
			resBuf.add(curNode.val);
			if(curNode.left!=null){nextLevel.add(curNode.left);}
			if(curNode.right!=null){nextLevel.add(curNode.right);}
			if(curLevel.isEmpty()){
			res.addFirst(new LinkedList<Integer>(resBuf));
			curLevel=new LinkedList<TreeNode>(nextLevel);
			resBuf.clear();
			nextLevel.clear();
		}
		}
		return res;
		    }
	public int reverse(int x) {
		if(x==0){
			return 0;
		}
		boolean isPos=x>0?true:false;
		int absX=Math.abs(x);
		int res=0;
		while(x>0){
			int cur=x%10;
			if(isPos){
				if(res<(Integer.MAX_VALUE-cur)/10)
				{
					res=10*res+cur;
				}
				else{
					return 0;
				}
			}
			else if(!isPos){
				if(res>(Integer.MIN_VALUE+cur)/10)
				{
					res=10*res-cur;
				}
				else{
					return 0;
				}
			}
			absX=absX/10;
		}
		return res;
	}

}
