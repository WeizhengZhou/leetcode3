package xx;

public class ConverSortedList2BST {
	 public TreeNode sortedListToBST(ListNode head) {
	        if(head==null)return null;
	        if(head.next==null)return new TreeNode(head.val);
	        ListNode pre=null;
	        ListNode slow=head;
	        ListNode fast=slow.next;
	        while(fast!=null && fast.next!=null){
	            pre=slow;
	            slow=slow.next;
	            fast=fast.next.next;
	        }
	        if(pre!=null)pre.next=null;
	        TreeNode root=new TreeNode(slow.val);
	        ListNode left=pre==null?null:head;
	        root.left=sortedListToBST(left);
	        root.right=sortedListToBST(slow.next);
	        return root;
	    }
}
