package additional;

public class ReverseString {
	public static void main(String[] args) {
		ReverseString r = new ReverseString();
		System.out.println(r.reverseString("hello"));
	}
    public String reverseString(String s) {
        if (s==null || s.length()<=1) return s;
        int l=0;
        int r=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        //way1
        //return sb.reverse().toString();
        // way2
        while(l<r) {
        	char left=s.charAt(l);
        	char right=s.charAt(r);
        	sb.setCharAt(l++, right);
        	sb.setCharAt(r--, left);
        }
        return sb.toString();
    }
}
