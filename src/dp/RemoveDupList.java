package dp;

public class RemoveDupList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
        	return head;
        }
        ListNode cur=head;
        int pre=head.val+1;
        ListNode dummy=new ListNode(0);
        ListNode last=dummy;
        while(cur!=null){
        	if(cur.val!=pre){
        		last.next=cur;
        		pre=cur.val;
        		last=cur;
        	}
        	cur=cur.next;
        }
        last.next=null;
        return dummy.next;
    }
}
