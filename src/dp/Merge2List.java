package dp;

public class Merge2List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
        	return l1==null?l2:l1;
        }
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while(l1!=null&&l2!=null){
        	if(l1.val<l2.val){
        		cur.next=l1;
        		l1=l1.next;
        	}
        	else{
        		cur.next=l2;
        		l2=l2.next;
        	}
        	cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return dummy.next;
    }

}
