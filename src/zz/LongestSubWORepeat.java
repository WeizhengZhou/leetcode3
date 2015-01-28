package zz;

import java.util.HashSet;
import java.util.Set;

public class LongestSubWORepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0){
			return 0;
		}
		Set<Character> visited=new HashSet<>();
		int len=0;
		int start=0;
		for(int i=0;i<s.length();i++){
			char cur=s.charAt(i);
			if(visited.contains(cur)){
				while(start<i && s.charAt(start)!=cur){
					visited.remove(s.charAt(start));
					start++;
				}
				visited.remove(s.charAt(start));
			}
			visited.add(cur);
			len=Math.max(len, i-start+1);
		}
		return len;
	}

}
