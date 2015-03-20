package xx;

public class ReverseNodesKGroup {
	 public ListNode reverseKGroup(ListNode head, int k) {
	     if(head==null||k<=1){return head;}
	     ListNode dummy=new ListNode(0);
	     ListNode pre=dummy;
	     dummy.next=head;
	     ListNode reversePre=pre;
	     ListNode reverseNext=head;
	     ListNode reverseStart=head;
	     ListNode reverseEnd=pre;
	     int steps=0;
	     while(reverseEnd!=null){
	         if(steps==k){
	             reverse(reversePre,reverseNext,reverseStart,reverseEnd);
	             steps=0;
	             reversePre=reverseStart;
	             reverseStart=reverseNext;
	         }
	         steps++;
	         reverseEnd=reverseNext;
	         if(reverseNext!=null){
	            reverseNext=reverseNext.next;
	         }
	     }
	     return dummy.next;
	 }
	 private void reverse(ListNode reversePre,ListNode reverseNext,ListNode reverseStart,ListNode reverseEnd){
	         reverseEnd.next=null;
	         ListNode pre=reversePre;
	         ListNode cur=reverseStart;
	         ListNode next=cur.next;
	         while(cur!=null){
	             next=cur.next;
	             cur.next=pre;
	             pre=cur;
	             cur=next;
	         }
	         reversePre.next=reverseEnd;
	         reverseStart.next=reverseNext;
	 }
}
