package gogo;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null ||strs.length==0 ||strs[0] == null || strs[0].length()==0) return "";
        int index=0;
        while (index<strs[0].length()) {
        	char cur = strs[0].charAt(index);
        	for(int i=1;i<strs.length;i++) {
        		if (strs[i]==null || index>strs[i].length() || strs[i].charAt(index) != cur) 
        			return strs[0].substring(0,index);
        	}
        	index++;
        }
        return strs[0].substring(0,index);
    }
}
