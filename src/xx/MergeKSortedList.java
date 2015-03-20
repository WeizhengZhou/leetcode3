package xx;
import java.util.*;
public class MergeKSortedList {
	public ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null || lists.size()==0)return null;
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        PriorityQueue<ListNode> heap=new PriorityQueue<>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                //ListNode n1=(ListNode)o1;
                //ListNode n2=(ListNode)o2;
                return o1.val-o2.val;
            }
        });
        for(int i=0;i<lists.size();i++){
            if(lists.get(i)!=null)
            heap.add(lists.get(i));
        }
        while(!heap.isEmpty()){
            ListNode node=heap.poll();
            cur.next=node;
            cur=cur.next;
            if(node.next!=null){heap.add(node.next);}
        }
        return dummy.next;
    }
}
