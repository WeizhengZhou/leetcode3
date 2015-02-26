package xx;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		ReorderList r=new ReorderList();
		r.reorderList(head);

	}
    public void reorderList(ListNode head) {
        if(head==null ||head.next==null)return;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reverseHead=slow.next;
        slow.next=null;
        ListNode reverseNode=reverse(reverseHead);
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        ListNode node=head;
        while(reverseNode!=null){
            tail.next=node;
            //System.out.println("tail="+tail.val);
            //System.out.println("node="+node.val);
            node=node.next;
            
            tail=tail.next;
            tail.next=reverseNode;
            reverseNode=reverseNode.next;
            //System.out.println("reverse node="+reverseNode.val);
            tail=tail.next;
        }
        tail.next=node;
    }
    private ListNode reverse(ListNode node){
        if(node==null)return null;
        
        ListNode pre=node;
        ListNode cur=node.next;
        ListNode next=null;
        node.next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
