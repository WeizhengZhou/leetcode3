package xx;

public class IntersectionTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null || headB==null) return null;
		int lenA=0;
		int lenB=0;
		ListNode curA=headA;
		ListNode curB=headB;
		while(curA!=null||curB!=null){
		    if(curA!=null){
		        lenA++;
		        curA=curA.next;
		    }
		    if(curB!=null){
		        lenB++;
		        curB=curB.next;
		    }
		}
		ListNode longList=lenA>=lenB?headA:headB;
		ListNode shortList=lenA<lenB?headA:headB;
		for(int i=0;i<Math.abs(lenA-lenB);i++)longList=longList.next;
		while(longList!=null && shortList!=null){
		    if(longList==shortList)return longList;
		    longList=longList.next;
		    shortList=shortList.next;
		}
		return null;
    }
}
