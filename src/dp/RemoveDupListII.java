package dp;

public class RemoveDupListII {

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
        int count=1;
        while(cur!=null){
        	if(cur.val!=pre){       		
        		
        		if(count==0){
        			last.next=new ListNode(pre);
            		last=last.next;
        		}
        		pre=cur.val;
        		count=0;
        	}
        	else{
        		count++;
        	}
        	cur=cur.next;
        }
        if(count==0){
    		last.next=new ListNode(pre);
    		last=last.next;
		}
        last.next=null;
        return dummy.next;
    }

}
