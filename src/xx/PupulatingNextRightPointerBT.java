package xx;

public class PupulatingNextRightPointerBT {
	public void connect(TreeLinkNode root) {
		 if(root==null){return;}
		 TreeLinkNode curLevel=root;
		 TreeLinkNode next=null;
		 while(curLevel!=null){
		     next=curLevel.left;
		     TreeLinkNode cur=curLevel;
		     while(cur!=null && next!=null){
		         cur.left.next=cur.right;
		         cur.right.next=cur.next==null?null:cur.next.left;
		         cur=cur.next;
		     }
		     curLevel=next;
		 }
   }
}
