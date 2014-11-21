package dp;

public class ValidPalin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((char)(65));

	}
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0){
        	return true;
        }
        String trim=s.trim();
        int l=0;
        int r=trim.length()-1;
        while(l<r&&!isAlphaNumeric(trim.charAt(l))){
    		l++;
    	}
        while(r>l&&!isAlphaNumeric(trim.charAt(r))){
    		r--;
    	}
        while(l<r){
        	if(!trim.substring(l,l+1).equalsIgnoreCase(trim.substring(r, r+1))){
        		return false;
        	}
        	while(l+1<r&&!isAlphaNumeric(trim.charAt(l+1))){
        		l++;
        	}
        	while(r-1>l&&!isAlphaNumeric(trim.charAt(r-1))){
        		r--;
        	}
        	l++;
        	r--;
        }
        return true;
    }
    private boolean isAlphaNumeric(char c){
        if(c >= 'A' && c <= 'Z') return true;
		if(c >= 'a' && c <= 'z') return true;
        if(c >= '0' && c <= '9') return true;
        return false;
	}

}
