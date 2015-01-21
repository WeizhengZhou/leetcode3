package zz;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode rotateRight(ListNode head, int n) {
		if(head==null || n==0){
			return head;
		}
		int len=0;
		ListNode cur=head;
		while(cur!=null){
			cur=cur.next;
			len++;
		}
		n=n%len;
		if(n==0){
			return head;
		}
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode pre=dummy;
		ListNode iterator=head;
		ListNode nth=head;
		for(int i=0;i<n;i++){
			if(nth!=null)
			{
				nth=nth.next;
			}
		}
		if(nth==null){
			return head;
		}
		ListNode preNth=nth;
		while(nth!=null){
			preNth=nth;
			pre=iterator;
			iterator=iterator.next;
			nth=nth.next;
		}
		pre.next=null;
		dummy.next=iterator;
		preNth.next=head;
		return dummy.next;
	}
}
