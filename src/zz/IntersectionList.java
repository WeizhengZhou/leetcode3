//zz reviewed
//zz discuss

package zz;

public class IntersectionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode A1=new ListNode(3);
		ListNode A2=new ListNode(2);
		ListNode A3=new ListNode(3);
		ListNode B1=new ListNode(0);
		ListNode B2=new ListNode(2);
		ListNode B3=new ListNode(3);
		A2.next=A1;
		//A2.next=A3;
		//B1.next=B2;
		//B2.next=B3;
		//B3.next=A2;
		IntersectionList in=new IntersectionList();
		System.out.println(in.getIntersectionNode(A1, A2).val);

	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode A=headA;
		ListNode B=headB;
		while(A!=null && B!=null){
			A=A.next;
			B=B.next;
		}
		int count=0;
		ListNode longHead=A!=null?A:B;
		ListNode longList=longHead==A?headA:headB;
		ListNode shortList=longList==headA?headB:headA;
		while(longHead!=null){
			longHead=longHead.next;
			count++;
		}
		System.out.println(count);
		
		for(int i=0;i<count;i++){
			longList=longList.next;
		}
		System.out.println(longList.val);		
		System.out.println(shortList.val);
		while(longList!=null && shortList!=null){
			//System.out.println(longList.val+" "+shortList.val);
			if(longList==shortList){
				return longList;
			}
			longList=longList.next;
			shortList=shortList.next;
		}
		return null;
	}
}
