//zz reviewed
package zz;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || m==n){
			return head;
		}
		ListNode dummyHead=new ListNode(0);
		dummyHead.next=head;
		ListNode preReverse=dummyHead;
		ListNode reverseStart=head;
		ListNode reverseEnd=head;
		ListNode afterReverse=head;
		//zz, check m and n, if they are larger than the length of list, you will have null pointer exception
		int i=1;
		for(;i<m;i++){
			preReverse=reverseStart;
			reverseStart=reverseStart.next;
			reverseEnd=reverseEnd.next;
		}
		for(;i<n;i++){
			reverseEnd=reverseEnd.next;
		}
		afterReverse=reverseEnd.next;
		reverseEnd.next=null;
		ListNode cur=reverseStart.next;
		ListNode pre=reverseStart;
		ListNode next=null;
		while(cur!=null){
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;			
		}
		preReverse.next=reverseEnd;
		reverseStart.next=afterReverse;
		return dummyHead.next;
	}
	/*zz consider this code
       public ListNode reverseBetween(ListNode head, int m, int n){
		ListNode dh = new ListNode(0);	
		ListNode tail = dh;
		ListNode preTail = null;
		ListNode nextHead = null;	
		int count = 0;
		while(head != null){
			count ++;
			if(count <= m){
				preTail = tail;
				tail.next = head;
				tail = tail.next;
				head = head.next;
			}
			else if(count <= n){	
			        nextHead = head.next;
				head.next = preTail.next;
				preTail.next = head;	
 				head = nextHead;
		        }
                        else
				break;	
		}
		tail.next = head;
		return dh.next;
	}

*/

}
