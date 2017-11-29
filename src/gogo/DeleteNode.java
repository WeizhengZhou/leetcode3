package gogo;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        if (node==null||node.next==null) return;
        while(node.next!=null) {
        	node.val=node.next.val;
        	node=node.next;
        }
        node.next=null;
    }
}
