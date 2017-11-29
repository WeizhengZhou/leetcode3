package gogo;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        if (s==null || s.length() == 0) return 0;
        s=s.trim();
        int count = 0;
        int i=s.length()-1;
        while(i>=0 && s.charAt(i) != ' '){
        	count++;
        	i--;
        }
        return count;
    }
}
