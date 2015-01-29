//zz reviewd
package zz;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public ListNode mergeKLists(List<ListNode> lists) {
		 if(lists==null || lists.size()==0){
			 return null;
		 }
		 ListNode dummy=new ListNode(0);//zz dummyHead, to emphsize the "head"
		 ListNode cur=dummy;//zz tail
		 PriorityQueue<ListNode> heap=new PriorityQueue<>(lists.size(),new Comparator<ListNode>(){

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}});
		 for(ListNode head:lists){
			 if(head!=null)
			 {
				 heap.add(head);
			 }
		 }
		 while(!heap.isEmpty()){
			 cur.next=heap.poll();//zz tail.next = heap.remove(), remove
			 cur=cur.next;//zz update tail
			 if(cur.next!=null)
			 {
				 heap.add(cur.next);
			 }
		 }
		 return dummy.next;
	 }

}
