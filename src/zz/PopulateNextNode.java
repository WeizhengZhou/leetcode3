package zz;

public class PopulateNextNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public void connect(TreeLinkNode root) {
		 if(root==null){
			 return;
		 }
		 TreeLinkNode first=root;
		 TreeLinkNode next=null;
		 while(first!=null){
			 next=first.left;
			 TreeLinkNode cur=first;
			 while(cur!=null && next!=null){
				 cur.left.next=cur.right;
				 cur.right.next=cur.next==null?null:cur.next.left;
				 cur=cur.next;
			 }
			 first=next;
		 }
	 }

}
