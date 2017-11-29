package gogo;

public class ReverseWords {
    public String reverseWords(String s) {
        if (s==null || s.length()==0) return s;
        s=s.trim();
        if (s.length()==0) return s;
        StringBuilder sb=new StringBuilder();
        int end = s.length();
        int start = s.length()-1;
        while (start>=0) {
        	if (s.charAt(start) !=' ') {
        		start--;
        	} else {
        		sb.append(' ');
        		sb.append(s.substring(start+1, end));
        		end=start;
        		start--;
        	}      	
        }
        sb.append(' ');
		sb.append(s.substring(0, end));
        return sb.toString().trim();
    }
}
