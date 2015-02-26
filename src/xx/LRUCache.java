package xx;

public class LRUCache {
	private class ListNode{
		int key;
		int val;
		ListNode pre;
		ListNode next;
		public ListNode(int x,int y){key=x;val=y;}
	}
	private int capacity=0;
	private int count=0;
	private ListNode dummyHead;
	private ListNode dummyTail;
	private Map<Integer,ListNode> map;

	public LRUCache(int capacity){
		dummyHead=new ListNode(0,0);
		dummyTail=new ListNode(0,0);
		dummyHead.next=dummyTail;
		dummyTail.pre=dummyHead;
		this.capacity=capacity;
		map=new HashMap<>(capacity);	
	}
	public void set(int key, int value){
		ListNode node=map.get(key);
		if(node==null){
			if(count==capacity){
				ListNode deleteNode=dummyTail.pre;
				delete(deleteNode);
				map.remove(deleteNode.key);
				count--;
			}
			node=new ListNode(key,value);
			count++;
		}
		else{
			delete(node);
		}
		addFirst(node);
		node.val=value;
		map.put(key,node);

	}
	public int get(int key){
		if(map.isEmpty() || !map.containsKey(key)){return -1;}
		ListNode node=map.get(key);
		delete(node);
		addFirst(node);
		return node.val;
	}
	private void delete(ListNode node){
		node.pre.next=node.next;
		node.next.pre=node.pre;
	}

	private void addFirst(ListNode node){
		ListNode next=dummyHead.next;
		dummyHead.next=node;
		node.pre=dummyHead;
		node.next=next;
		next.pre=node;
	}
}
