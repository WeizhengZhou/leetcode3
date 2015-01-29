//zz reviewed
package zz;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulateNextNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		new PopulateNextNodeII().connect(root);

	}
	
//	public void connect(TreeLinkNode root) {
//		if(root==null){
//			return;
//		}
//		Queue<TreeLinkNode> cur=new LinkedList<TreeLinkNode>();
//		Queue<TreeLinkNode> next=new LinkedList<TreeLinkNode>();
//		cur.add(root);
//		while(!cur.isEmpty()){
//			TreeLinkNode node=cur.poll();
//			if(node.left!=null){
//				next.add(node.left);
//			}
//			if(node.right!=null){
//				next.add(node.right);
//			}
//			if(!cur.isEmpty()){
//				node.next=cur.peek();
//			}
//			else{
//				cur=new LinkedList<TreeLinkNode>(next);
//				next.clear();
//			}
//		}
//		
//	}
	public void connect(TreeLinkNode root){
		if(root == null) return;
		root.next = null;		
		TreeLinkNode preLevelHead = root;
		TreeLinkNode parent = null;
		TreeLinkNode child = null;
		while(preLevelHead != null){
			parent = preLevelHead;
			child = null;
			//find the curLevel's head
			while(parent != null){
				if(parent.left != null){
					child = parent.left;
					break;
				}
				else if(parent.right != null){
					child = parent.right;
					break;
				}
				else{
					parent = parent.next;
				}
			}
			preLevelHead = child;//store curLevel's head for next level's usage
			while(parent != null){
				if(child == parent.left && parent.right != null){
					child.next = parent.right;
					child = child.next;
				}
				else{
					parent = parent.next;
					while(parent != null){
						if(parent.left != null){
							child.next = parent.left;
							child = child.next;
							break;
						}
						else if(parent.right != null){
							child.next = parent.right;
							child = child.next;
							break;
						}
						else{
							parent = parent.next;
						}
					}
				}
			}
		}
	}
}


