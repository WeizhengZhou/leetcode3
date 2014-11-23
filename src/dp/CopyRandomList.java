package dp;

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
        RandomListNode dummy=new RandomListNode(0);
        RandomListNode cpCur=dummy;
        RandomListNode cur=head;
        Map<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
        while(cur!=null){
        	RandomListNode cp=new RandomListNode(cur.label);
        	map.put(cur, cp);
        	cpCur.next=cp;
        	cpCur=cp;
        	cur=cur.next;       			
        }
        cur=head;
        cpCur=dummy.next;
        while(cur!=null){
        	RandomListNode random=cur.random;
        	RandomListNode cp=map.get(cur);
        	RandomListNode cpRandom=random==null?null:map.get(random);
        	cp.random=cpRandom;
        	cur=cur.next;
        }
        return dummy.next;
    }
}
