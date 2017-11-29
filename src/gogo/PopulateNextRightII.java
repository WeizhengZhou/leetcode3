package gogo;

public class PopulateNextRightII {
    public void connect(TreeLinkNode root) {
        if (root ==null) return;
        TreeLinkNode cur = root;
        while(cur != null) {
        	TreeLinkNode next = null;
        	while (next == null) {
        		if (cur.left != null) {
        			next = cur.left;
        		} else if (cur.right != null) {
        			next= cur.right;
        		} else {
        			cur=cur.next;
        		}
        		if (cur==null) return;
        	}
        	TreeLinkNode nextLv=next;
        	if (nextLv==cur.left) {
        		if (cur.right!=null){
        			nextLv.next = cur.right;
        			nextLv = nextLv.next;
        		}
        	}
        	cur=cur.next;
        	while (cur != null) {
        		if (cur.left!=null) {
        			nextLv.next = cur.left;
        			nextLv = nextLv.next;
        		}
        		if (cur.right!=null) {
        			nextLv.next = cur.right;
        			nextLv = nextLv.next;
        		}
        		cur=cur.next;
        	}
        	cur = next;
        }
    }
}
