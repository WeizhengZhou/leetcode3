package dp;

public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(2);
		ListNode l2=new ListNode(1);
		l1.next=l2;
		SortList s=new SortList();
		ListNode h=s.sortList(l1);
		while(h!=null){
			System.out.println(h.val);
			h=h.next;
		}

	}
    public ListNode sortList(ListNode head) {
    	if(head==null){
    		return null;
    	}
    	if(head.next==null){
    		return head;
    	}
        return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head){
    	if(head==null){
    		return null;
    	}
    	if(head.next==null){
    		return head;
    	}
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	ListNode pre=head;
    	ListNode slow=head;
    	ListNode fast=head.next;
    	while(fast!=null && fast.next!=null){
    		pre=slow;
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	System.out.println("pre="+pre.val+",slow="+slow.val+",fast="+fast.val);
    	pre.next=null;
    	ListNode cur=dummy;
    	ListNode left=mergeSort(head);
    	ListNode right;
    	if(slow==head)
    	{
    		right=mergeSort(fast);
    	}
    	else{
    		right=mergeSort(slow);
    	}
    	
    	//System.out.println("left="+left.val+",right="+right.val);
    	while(left!=null && right!=null){
    		if(left.val<right.val){
    			cur.next=left;
    			left=left.next;
    		}
    		else{
    			cur.next=right;
    			right=right.next;
    		}
    		cur=cur.next;
    	}
    	cur.next=left==null?right:left;
    	return dummy.next;
    }
}
