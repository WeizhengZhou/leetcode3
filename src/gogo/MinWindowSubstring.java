package gogo;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
	public String minWindow(String s, String t) {
        if (s=="" || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<> ();
        for (int i=0;i<t.length();i++) {
        	char c = t.charAt(i);
        	int count = map.containsKey(c) ? map.get(c) : 0;
        	map.put(c, count+1);
        }
        int start = 0;
        int count = t.length();
        int min = Integer.MAX_VALUE;
        String subString = "";
        for( int i=0;i<s.length();i++) {
        	char c=s.charAt(i);
        	if (!map.containsKey(c)) continue;
        	int times = map.get(c);
        	if (times>0) {
        		count--;
        	}
        	map.put(c, times-1);
        	while(count<=0) {
        		if (i-start+1<min) {
        			min = i-start+1;
        			subString = s.substring(start,start+min);        				
        		}
        		
        		char sChar = s.charAt(start);
        		if (!map.containsKey(sChar)) {
        			start++;
        			continue;
        		}
        		int sTimes = map.get(sChar);
        		if (sTimes==0) {
        			count++;
        		}
        		map.put(sChar, sTimes+1);
        		start++;
        	}
        }
        return subString;
    }
}
