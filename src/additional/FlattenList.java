package additional;

public class FlattenList {
	
	class ListNode{
		int val;
		ListNode next;
		ListNode nextLevelHead;
		ListNode(int x){
			val=x;
			next=null;
			nextLevelHead=null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlattenList f=new FlattenList();
		ListNode n1=f.new ListNode(1);
		ListNode n2=f.new ListNode(2);
		ListNode n3=f.new ListNode(3);
		ListNode n4=f.new ListNode(4);
		ListNode n5=f.new ListNode(5);
		n1.nextLevelHead=n2;
		n2.nextLevelHead=n3;
		n2.next=n4;
		n1.next=n5;
		f.flattenList(n1);
		while(n1!=null){
			System.out.println(""+n1.val);
			n1=n1.next;
		}
	}
	
	public ListNode flattenList(ListNode head){
		/*if(head==null){
			return null;
		}*/
		ListNode end=head;
		ListNode next=head.next;
		if(head.nextLevelHead!=null){
			end=flattenList(head.nextLevelHead);
			head.next=head.nextLevelHead;
			end.next=next;
		}		
		return next!=null?flattenList(next):end;		
	}

}
