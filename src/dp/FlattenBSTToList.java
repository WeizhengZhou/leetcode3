package dp;

import java.util.LinkedList;
import java.util.List;

public class FlattenBSTToList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode r=new TreeNode(1);
		r.left=new TreeNode(2);
		r.left.left=new TreeNode(3);
		FlattenBSTToList m=new FlattenBSTToList();
		m.printTree(r);
		System.out.println("");
		m.flatten(r);
		m.printTree(r);

	}
	
	public void printTree(TreeNode r){
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
	
    public void flatten(TreeNode root) {
        if (root==null){
        	return;
        }
        helper(root);
    }
    
    public TreeNode helper(TreeNode r){
    	TreeNode right=r.right;
    	TreeNode head=r;
    	if (r.left!=null){
    		r.right=helper(r.left);
    		r.left=null;
        	while(r.right!=null){
        		r=r.right;
        	}
    	}
    	if(right!=null){
    		r.right=helper(right);
    	}
    	return head;
    }

}
