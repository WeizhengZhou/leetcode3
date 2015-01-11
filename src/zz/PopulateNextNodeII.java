package zz;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulateNextNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void connect(TreeLinkNode root) {
		if(root==null){
			return;
		}
		Queue<TreeLinkNode> cur=new LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> next=new LinkedList<TreeLinkNode>();
		cur.add(root);
		while(!cur.isEmpty()){
			TreeLinkNode node=cur.poll();
			if(node.left!=null){
				next.add(node.left);
			}
			if(node.right!=null){
				next.add(node.right);
			}
			if(!cur.isEmpty()){
				node.next=cur.peek();
			}
			else{
				cur=new LinkedList<TreeLinkNode>(next);
				next.clear();
			}
		}
		
	}

}
