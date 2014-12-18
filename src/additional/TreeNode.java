package additional;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode(int n){
		value=n;
		left=null;
		right=null;
	}
	
	public static void printTree(TreeNode r){
		if(r==null){
			return;
		}
		List<TreeNode> cur=new LinkedList<TreeNode>();
		List<TreeNode> next=new LinkedList<TreeNode>();
		cur.add(r);
		System.out.print(r.value+" ");
		while(!cur.isEmpty()){
			for(TreeNode t:cur){
				if(t.left!=null){
					System.out.print(t.left.value+" ");
					next.add(t.left);
				}
				else
				{
					System.out.print("# ");
				}
				if(t.right!=null){
					System.out.print(t.right.value+" ");
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
