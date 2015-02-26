package xx;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
	    List<List<Integer>> res=new LinkedList<>();
	    if(root==null){return res;}
	    dfsHelper(root,sum,new LinkedList<Integer>(),res);
	    return res;
	}
	private void dfsHelper(TreeNode root,int sum,List<Integer> buf,List<List<Integer>> res){
	    if(root==null){return;}
	    sum-=root.val;
	    buf.add(root.val);
	    if(root.left==null && root.right==null && sum==0){
	        res.add(new LinkedList<Integer>(buf));
	        buf.remove(buf.size()-1);
	        return;
	    }
	    dfsHelper(root.left,sum,buf,res);
	    dfsHelper(root.right,sum,buf,res);
	    buf.remove(buf.size()-1);
	}
}
