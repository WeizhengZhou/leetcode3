package zz;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isPalindrome(String s) {
		if(s==null || s.length()==0){
			return true;
		}
		StringBuilder sb=new StringBuilder();
		char c=' ';
		for(int i=0;i<s.length();i++){
			c=s.charAt(i);
			if(c>='a'&& c<='z' || c>='A' && c<='Z' || c>='0' && c<='9'){
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

}
