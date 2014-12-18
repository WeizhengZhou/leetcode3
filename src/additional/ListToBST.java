package additional;

public class ListToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(0);
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		head.next=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		//n4.next=n5;
		ListToBST l=new ListToBST();
		TreeNode t=l.listToBST(head);
		TreeNode.printTree(t);
	}
	
	public TreeNode listToBST(ListNode head){
		if(head==null){
			return null;
		}
		if(head.next==null){
			return new TreeNode(head.value);
		}
		ListNode pre=null;
		ListNode slow=head;
		ListNode fast=head.next;
		while(fast!=null && fast.next!=null){
			pre=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		if(pre==null){
			TreeNode n=new TreeNode(head.value);
			n.right=new TreeNode(head.next.value);
			return n;
		}
		TreeNode rt=new TreeNode(slow.value);
		pre.next=null;
		rt.left=listToBST(head);
		rt.right=listToBST(slow.next);
		return rt;
	}

}
