package additional;

public class ReverseVowels {
	public static void main(String[] args) {
		ReverseVowels r = new ReverseVowels();
		System.out.println(r.reverseVowels("leetcode"));
	}
	public String reverseVowels(String s) {
		if (s==null || s.length()<=1) return s;
        int l=0;
        int r=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        while(l<r) {
        	char left=s.charAt(l);
        	char right=s.charAt(r);
        	if (!isVowel(left)) {
        		l++;
        	} else if (!isVowel(right)) {
        		r--;
        	} else {
        		sb.setCharAt(l++, right);
            	sb.setCharAt(r--, left);
        	}        	        	
        }
        return sb.toString();
    }
	private boolean isVowel(char c) {
		return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'|| c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
	}
}
