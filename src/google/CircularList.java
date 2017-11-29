
public class CircularList {
	public CircularNode insert(CircularNode head, int x){
		if(head == null){
			CircularNode n = new CircularNode(x);
			n.next = n;
			head = n;
			return head;
		}
		else if(head.val > x){
			System.out.println("OK");
			CircularNode n = new CircularNode(head.val);
			n.next = head.next;
			head.next = n;
			head.val = x;
			return head;
		}
		else{
			CircularNode pre = head;
			CircularNode cur = head.next;
			while(cur != head && cur.val < x){
				pre = cur;
				cur = cur.next;
			}
			CircularNode n = new CircularNode(x);
			pre.next = n;
			n.next= cur;
			return head;
		}
	}
	public static void main(String[] args){
		CircularNode head = new CircularNode(1);
		head.next = new CircularNode(2);
		head.next.next = new CircularNode(4);
		head.next.next.next = head;
		new CircularList().insert(head,3);
		CircularNode cur = head;		
		while(true){
			System.out.println(cur.val + ", ");
			cur = cur.next;
			if(cur == head)
				break;
		}
	}
}
class CircularNode{
	int val;
	CircularNode next;
	public CircularNode(int val){
		this.val = val;
	}
}
