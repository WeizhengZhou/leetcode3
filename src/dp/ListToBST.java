package dp;

public class ListToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n=new ListNode(1);
		n.next=new ListNode(2);
		n.next.next=new ListNode(3);
		n.next.next.next=new ListNode(4);
		ListToBST l=new ListToBST();
		TreeNode r=l.sortedListToBST(n);
		TreeNode.printTree(r);

	}
	
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
        	return null;
        }
    	if (head.next==null){
    		return new TreeNode(head.val);
    	}
    	ListNode first=head;
    	ListNode cur=head;
    	ListNode next=head.next;
    	ListNode pre=null;
    	while(next!=null&&next.next!=null){
    		pre=cur;
    		cur=cur.next;
    		next=next.next.next;
    	}
    	if(pre==null){
    		first=null;
    	}
    	else
    	{
    		pre.next=null;
    	}
    	
    	TreeNode root=new TreeNode(cur.val);
    	root.left=sortedListToBST(first);
    	root.right=sortedListToBST(cur.next);
    	return root;
    	
    }

}
