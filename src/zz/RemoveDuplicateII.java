//zz reviewed
package zz;

public class RemoveDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode deleteDuplicates(ListNode head) {
		 if(head==null){
			 return null;
		 }
		 ListNode dummyHead=new ListNode(0);
		 ListNode cur=dummyHead;//zz tail
		 long pre=Long.MAX_VALUE;//zz why use long?, preValue
		 while(head!=null){
			 if(head.next==null){
				 if(head.val!=pre){
					 cur.next=head;
					 cur=cur.next;
				 }				 
				 break;
			 }
			 if(head.val!=head.next.val){
				 cur.next=head;
				 cur=cur.next;
				 head=head.next;
			 }
			 else{
				 while(head!=null && head.next!=null && head.val==head.next.val){
					 head=head.next;
					 pre=head.val;
				 }
				 if(head!=null){
					 head=head.next;
				 }
			 }
		 }
		 cur.next=null;
		 return dummyHead.next;
	 }
	//zz
	//consider this solution
/*
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while(head != null){
                if(head.next == null || head.val != head.next.val){
                    tail.next = head;
                    tail = tail.next;
                    head = head.next;
                }   
            else{
                ListNode cur = head.next;
                while(cur != null && cur.val == head.val)
                    cur = cur.next;
                head = cur;
            }
        }
            tail.next = null;
            return dummyHead.next;
    }
/*
        public ListNode deleteDuplicates(ListNode head) {
    	    if(head == null || head.next == null) return head;
            ListNode dh = new ListNode(head.val-1);
            dh.next = head;
            ListNode tail = head;
            head = head.next;
            ListNode preTail = dh;
      
            int previous = tail.val; 
            while(head != null){
		if(head.val == previous){
		    preTail.next = null;
                    tail = preTail;
		}
                else{
		    tail.next = head;
                    preTail = tail;
 		    tail = head;
                    previous = tail.val;
		}
                head = head.next;
	     }
             tail.next= null;
             return dh.next; 
    }

*/


*/

}
