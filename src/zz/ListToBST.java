package zz;

public class ListToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode pre=null;
		ListNode slow=head;
		ListNode fast=head.next;
		if(fast==null || fast.next==null){
			TreeNode rt= new TreeNode(head.val);
			if(fast!=null){
				rt.right=new TreeNode(fast.val);
			}
			return rt;
		}
		while(fast!=null && fast.next!=null){
			pre=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		pre.next=null;	
		TreeNode root=new TreeNode(slow.val);
		root.left=sortedListToBST(head);
		root.right=sortedListToBST(slow.next);
		return root;
	}

}
