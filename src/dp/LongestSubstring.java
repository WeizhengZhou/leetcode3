package dp;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstring l=new LongestSubstring();
		System.out.println(l.lengthOfLongestSubstring("bbbb"));

	}
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
        	return 0;
        }
        int l=0;
        int max=0;
        Set<Character> visited=new HashSet<Character>();
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);
        	if(!visited.contains(c)){
        		visited.add(c);
        		max=Math.max(max, Math.abs(i-l+1));
        	}
        	else{
        		while(l<i && s.charAt(l)!=c){
        			visited.remove(s.charAt(l));
        			l++;
        		}
        		l++;
        	}
        }
        return max;
    }
}
