package dp;

import java.util.LinkedList;
import java.util.List;

public class NextRightNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void Connect(TreeLinkNode root){
		if(root==null){
			return;
		}
		List<TreeLinkNode> cur=new LinkedList<TreeLinkNode>();
		List<TreeLinkNode> next=new LinkedList<TreeLinkNode>();
		cur.add(root);
		while(!cur.isEmpty()){
			TreeLinkNode t=cur.remove(0);
			t.next=cur.isEmpty()?null:cur.get(0);
			if(t.left!=null){
				next.add(t.left);
			}
			if(t.right!=null){
				next.add(t.right);
			}
			if (cur.isEmpty()){
				cur=new LinkedList<TreeLinkNode>(next);
				next.clear();
			}
			
		}
	}

}
