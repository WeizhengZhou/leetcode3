package dp;

public class NextRightNodeII {

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
			TreeLinkNode c=cur;
			while(c!=null){
				if(c.left!=null){
					next=c.left;
					break;
				}
				if(c.right!=null){
					next=c.right;
					break;
				}
				c=c.next;
			}
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
