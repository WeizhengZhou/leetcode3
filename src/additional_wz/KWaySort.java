package additional_wz;

import java.util.*;
public class KWaySort {
	public ListNode mergeKLists(List<ListNode> lists){
        if(lists == null) return null;
        int k = lists.size();
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        for(int i=0;i<k;i++){
            if(lists.get(i) != null){
                pq.add(lists.get(i));
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while(!pq.isEmpty()){
            ListNode top = pq.remove();
            tail.next = top;
            tail = top;
            if(top.next != null){
                pq.add(top.next);
            }
        }
        return dummyHead.next;
     }
	public static void main(String[] args){
//		ListNode h1 = new ListNode(1);
//		ListNode h2 = new ListNode(2);
//		h1.next = new ListNode(3);
//		h2.next = new ListNode(4);
		List<ListNode> lists = new ArrayList<>();
		lists.add(null);
//		lists.add(null);
		KWaySort solu = new KWaySort();
		ListNode head = solu.mergeKLists(lists);
		while(head != null){
			System.out.println(head.val + ", ");
			head = head.next;
		}
		
	}

}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
