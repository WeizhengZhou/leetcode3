package xx;

public class CopyListWithRandomPointer {
	 public RandomListNode copyRandomList(RandomListNode head) {
	       if(head==null){return null;}
	       RandomListNode dummy=new RandomListNode(0);
	       RandomListNode curCopy=dummy;
	       RandomListNode cur=head;
	       Map<RandomListNode,RandomListNode> map=new HashMap<>();
	       while(cur!=null){
	            RandomListNode copy=new RandomListNode(cur.label);
	            curCopy.next=copy;
	            curCopy=curCopy.next;
	            map.put(cur,curCopy);
	            cur=cur.next;
	       }
	       while(head!=null){
	           RandomListNode copy=map.get(head);
	           copy.random=map.get(head.random);
	           head=head.next;
	       }
	       return dummy.next;
	    }
}
