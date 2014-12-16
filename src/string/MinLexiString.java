package string;

public class MinLexiString{
	public String min(String s){
		if(s == null) return s;
		String t = s+s;
		String min = s;
		for(int i=0;i<=s.length();i++){
			if(t.substring(i,i+s.length()).compareTo(min) < 0)
				min = t.substring(i,i+s.length());
		}
		return min;
	}
	public static void main(String[] args){
		String s = "BCABDADAB";
		System.out.println(new MinLexiString().min(s));
	}		
}
