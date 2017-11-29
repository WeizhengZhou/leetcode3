package gogo;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s==null || s.length()<=1) return s;
        for(int i=s.length()-1;i>=0;i--) {
        	if (isPalidrome(i,s)) {
        		StringBuilder sb=new StringBuilder();
        		for(int j=s.length()-1;j>i;j--) {
        			sb.append(s.charAt(j));
        		}
        		sb.append(s);
        		return sb.toString();
        	}
        }
        return s;
    }
    
    private boolean isPalidrome(int index, String s) {
    	int l=0;
    	int r=index;
    	while(l<=r){
    		if(s.charAt(l) != s.charAt(r)) return false;
    		l++;
    		r--;
    	}
    	return true;
    }
}
