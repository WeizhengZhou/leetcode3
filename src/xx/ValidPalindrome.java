package xx;

public class ValidPalindrome {
	public boolean isPalindrome(String s){
		if(s==null || s.length()<=1 ){return true;}
		int l=0;
		int r=s.length()-1;	
		while(l<r){
			if(!isAlphaNum(s.charAt(l))){l++;}
			else if(!isAlphaNum(s.charAt(r))){r--;}
			else{
				if(Character.toUpperCase(s.charAt(l))!=Character.toUpperCase(s.charAt(r))){return false;}
				else{l++; r--;}
			}
		}
		return true;
	}

	private boolean isAlphaNum(char c){
		if(c>='a' && c<='z') return true;
		else if(c>='A' && c<='Z') return true;
		else if(c>='0' && c<='9') return true;
		else return false;
	}
}
