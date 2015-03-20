package xx;

public class ReverseWordString {
	public String reverseWords(String s) {
        if(s==null){return "";}
        s=s.trim();
        StringBuilder sb=new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            int end=i;
            while(i>=0 && s.charAt(i)!=' ')i--;
            int start=i;
            sb.append(s.substring(start+1,end+1));
            sb.append(" ");
            while(i>=0 && s.charAt(i)==' '){i--;}
        }
        return sb.toString().trim();
    }
}
