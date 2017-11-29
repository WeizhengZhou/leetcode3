package gogo;
class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
public class PopulateNextRight {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur = root;
        while(cur!=null) {
        	TreeLinkNode next = cur.left;
        	if (next == null) return;
        	while (cur!=null) {
        		cur.left.next=cur.right;
        		cur.right.next = cur.next == null ? null : cur.next.left;
        		cur=cur.next;
        	}
        	cur=next;
        }
    }
}
