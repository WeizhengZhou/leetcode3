package gogo;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
	public static void main(String[] args) {
		LongestSubstring l=new LongestSubstring();
		int re = l.lengthOfLongestSubstring("pwwkew");
		System.out.println(re);
	}
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length() ==0) return 0;
        Set<Character> set = new HashSet<> ();
        int start = 0;
        int max = 0;
        for (int i = 0; i<s.length(); i++) {System.out.println("i="+i);
        	char c = s.charAt(i);System.out.println("c="+c);
        	
        	if (!set.contains(c)) {System.out.println("not contain");
        		set.add(c);
        		max = Math.max(max, i-start+1);
        	} else {System.out.println("yes");
        		while(s.charAt(start) != c) {
        			set.remove(s.charAt(start));
        			start++;
        		}
        		start++;System.out.println("start="+start);
        	}System.out.println("max="+max); 
        	System.out.println("set:");
        	for (char se : set) {
        	    System.out.print(se + ", ");
        	}
        }
        return max;
    }
}
