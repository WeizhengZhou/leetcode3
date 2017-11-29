package gogo;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null) return true;
        Stack<Integer> s=new Stack<> ();
        ListNode it=head;
        while(it!=null){
        	s.push(it.val);
        	it=it.next;
        }
        it=head;
        while(!s.isEmpty()) {
        	if (s.pop()!=it.val) return false;
        	it=it.next;
        }
        return true;
    }
}
