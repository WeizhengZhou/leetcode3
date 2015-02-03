//zz reviewed
package zz;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//zz two round loop used
	//zz only one time needed
	public boolean isPalindrome(String s) {
		if(s==null || s.length()==0){
			return true;
		}
		StringBuilder sb=new StringBuilder();
		char c=' ';
		for(int i=0;i<s.length();i++){
			c=s.charAt(i);
			if(c>='a'&& c<='z' || c>='A' && c<='Z' || c>='0' && c<='9'){//zz write a function for this isAlphaNumber(char c)
				sb.append(c);
			}
		}
		int l=0;
		int r=sb.length()-1;
		String S=sb.toString();
		while(l<r){
			if(!S.substring(l, l+1).equalsIgnoreCase(S.substring(r, r+1))){
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	//consider my new code below
/*
 	public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) return true;
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(isAlphaNumber(s.charAt(l)) == false) l++;
            else if(isAlphaNumber(s.charAt(r)) == false) r--;
            else{
                if(isEqualIngoreCase(s.charAt(l),s.charAt(r)) == true){
                    l++;
                    r--;
                }   
                else
                    return false;
            }
        }
        return true;
    }
    private boolean isAlphaNumber(char c){
        if(c<='9' && c>='0') return true;
        if(c<='z' && c>='a') return true;
        if(c<='Z' && c>='A') return true;
        return false;
    }
    private boolean isEqualIngoreCase(char a, char b){
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
*/

}
