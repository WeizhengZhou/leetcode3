package gogo;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null || s.length()<=1) return true;
        int l=0;
        int r = s.length()-1;
        while(l<=r){
        	char lChar = s.charAt(l);
        	if (!isAlphaNumeric(lChar)) {
        		l++;
        		continue;
        	}
        	char rChar = s.charAt(r);
        	if (!isAlphaNumeric(rChar)) {
        		r--;
        		continue;
        	}
        	if (Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) return false;
        	l++;
        	r--;
        }
        return true;
    }
    private boolean isAlphaNumeric(char c){
    	if ('0'<=c && c<='9' || 'a'<=c && c<='z' || 'A'<=c && c<='Z') return true;
    	return false;
    }
}
