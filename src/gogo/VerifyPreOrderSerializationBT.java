package gogo;

import java.util.Stack;

public class VerifyPreOrderSerializationBT {
	public static void main(String[] args) {
		VerifyPreOrderSerializationBT v=new VerifyPreOrderSerializationBT();
		System.out.println(v.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}
    public boolean isValidSerialization(String preorder) {
    	if (preorder.equals("#")) return true;
        Stack<Character> s=new Stack<> ();
        int i=0;
        boolean poped=false;
        char top = ' ';
        String[] chars=preorder.split(",");
        while(i<chars.length) {
        	char c=chars[i].charAt(0);
        	if (c!='#') {
        		s.push(c);
                top=s.peek();
        		i++;
        		System.out.println(s.toString()+"  not null ");
        	} else {
        		if (s.isEmpty()) return false;
        		top=s.peek();
        		if (top!='#') {                    
                    s.push(c); 
                    //top=s.peek();
        			i++;
        			System.out.println(s.toString());
        		} else {
                    while(top == '#') {
                        s.pop();
                        if (s.isEmpty()) return false;
                        s.pop();
                        top=s.isEmpty()?' ':s.peek();
                    } 
                    if (s.isEmpty() && i<chars.length-1) return false;
                    if (!s.isEmpty()) {
                        s.push('#');
                    }
                    
                    i++;
        		}
        	}
        }
        System.out.println(s.toString());
        System.out.println(s.size());
        return s.isEmpty();
    }
}
