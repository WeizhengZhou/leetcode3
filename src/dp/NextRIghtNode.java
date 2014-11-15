package dp;

public class NextRIghtNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void Connect(TreeLinkNode root){
		if(root==null){
			return;
		}
		root.next=null;
		TreeLinkNode next=root;
		while(next!=null){
			TreeLinkNode cur=next;
			next=cur.left;
			if(next!=null){
				while(cur!=null){
					cur.left.next=cur.right;
					cur.right.next=cur.next==null?null:cur.next.left;
					cur=cur.next;
				}
			}
			
		}
	}

}
