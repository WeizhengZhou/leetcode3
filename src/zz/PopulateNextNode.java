//zz reviewed
package zz;

public class PopulateNextNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public void connect(TreeLinkNode root) {
		 if(root==null){
			 return;
		 }
		 TreeLinkNode first=root;//zz curLevelHead
		 TreeLinkNode next=null;//zz nextLevelHead
		 while(first!=null){//zz curLevelHead!=null
			 next=first.left;//zz nextLevelHead = curLevelHead.left;
			 TreeLinkNode cur=first;//zz cur = curLevelHead;
			 while(cur!=null && next!=null){
				 cur.left.next=cur.right;
				 cur.right.next=cur.next==null?null:cur.next.left;
				 cur=cur.next;
			 }
			 first=next;
		 }
	 }

}
