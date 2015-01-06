package zz;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null){
			return null;
		}
		RandomListNode cur=head;
		Map<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
		while(cur!=null){
			RandomListNode cp=new RandomListNode(cur.label);
			map.put(cur, cp);
			cur=cur.next;
		}
		cur=head;
		while(cur!=null){
			RandomListNode cp=map.get(cur);
			cp.next=map.get(cur.next);
			if(cur.random!=null)
			{
				cp.random=map.get(cur.random);
			}
			cur=cur.next;
		}
		return map.get(head);
	}

}
