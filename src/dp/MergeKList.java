package dp;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode mergeKLists(List<ListNode> lists) {
    	 if(lists==null||lists.size()==0){
    		 return null;
    	 }
    	 ListNode dummy=new ListNode(0);
    	 ListNode cur=dummy;
    	 Queue<ListNode> q=new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}});
    	 for(ListNode head:lists){
    		 if(head!=null){
	    		 q.add(head);
	    		 head=head.next;
    		 }
    	 }
    	 while(!q.isEmpty()){
    		 ListNode next=q.peek();
    		 cur.next=q.poll();
    		 if(next.next!=null){
     		    q.add(next.next);
     		 }
     		 cur=cur.next;
    	 }
    	 return dummy.next;
    }
}
