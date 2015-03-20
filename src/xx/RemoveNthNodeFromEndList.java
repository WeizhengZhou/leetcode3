package xx;

public class RemoveNthNodeFromEndList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n<=0){return head;}
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode last=head;
        ListNode delete=head;
        int i=0;
        while(last!=null){
            if(i<n){last=last.next;}
            else{
                pre=delete;
                delete=delete.next;
                last=last.next;
            }
            i++;
        }
        pre.next=delete.next;
        return dummy.next;
    }
}
