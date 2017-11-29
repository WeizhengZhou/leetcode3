package gogo;

public class ListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head ==null) return null;
        if (head.next==null) return new TreeNode(head.val);
        ListNode pre = null;
        ListNode mid = head;
        ListNode end = head.next;
        while(end!=null) {
        	pre = mid;
        	mid = mid.next;
        	end = end.next == null ? null : end.next.next;
        }
        TreeNode root = new TreeNode(mid.val);
        
        	pre.next = null;
        	root.left = sortedListToBST(head);

        root.right = sortedListToBST(mid.next);
        return root;
    }
}
