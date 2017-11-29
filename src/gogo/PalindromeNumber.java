package gogo;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
	    if (x>0 && x<10) return true;
	    if (x<0) return false;
	    int abs = x>0 ? x : -x;
	    int val = abs;
	    int div = 1;
	    while(val/div/10>0){
	    	div = div*10;
	    }
	    while(div>1){
	    	int last = val%10;
	    	int first = val/div;
	    	if (last!= first) return false;
	    	val = val%div;
	    	val = val/10;
	    	div = div/100;
	    }
	    return true;
	}
}
