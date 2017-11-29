package gogo;

public class SubString {
	public static void main(String[] args) {
		SubString s=new SubString();
		System.out.println(s.strStr("a", "a"));
		System.out.println("a".equals("a"));
	}
	
	public int strStr(String haystack, String needle) {
        if (haystack == null || needle ==null || haystack.length() < needle.length()) return -1;
        if (needle.length() == 0) return 0;
        for(int i=0;i<=haystack.length()-needle.length();i++) {
        	//System.out.println(haystack.substring(i, i+needle.length()));
        	if (haystack.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}
