package dp;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {	
	
	    public int val;
	    public TreeNode left;
	    public TreeNode right;
	    public TreeNode(int x) { val = x; }
	    
	    public static void printTree(TreeNode r){
			if(r==null){
				return;
			}
			List<TreeNode> cur=new LinkedList<TreeNode>();
			List<TreeNode> next=new LinkedList<TreeNode>();
			cur.add(r);
			System.out.print(r.val+" ");
			while(!cur.isEmpty()){
				for(TreeNode t:cur){
					if(t.left!=null){
						System.out.print(t.left.val+" ");
						next.add(t.left);
					}
					else
					{
						System.out.print("# ");
					}
					if(t.right!=null){
						System.out.print(t.right.val+" ");
						next.add(t.right);
					}
					else
					{
						System.out.print("# ");
					}
				}
				//System.out.println("");
				cur=new LinkedList<TreeNode>(next);
				next.clear();
			}
		}

}
