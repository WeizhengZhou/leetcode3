package gogo;

public class LongestPalindrom {
	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) return s;
        int len = s.length();
        boolean[][] isPa = new boolean[len][len];
        int start = 0;
        int end = 0;
        for (int i = 0; i<len-1; i++) {
        	isPa[i][i] = true;
        	isPa[i][i+1] = s.charAt(i) == s.charAt(i+1) ? true : false;
            if (isPa[i][i+1]) {start = i; end = i+1;}
        }
        isPa[len-1][len-1] = true;
        for (int d = 2; d<len; d++) {
        	for (int i=0; i<len-d;i++) {
        		isPa[i][i+d] = s.charAt(i) == s.charAt(i+d) ? isPa[i+1][i+d-1] : false;
        		if (isPa[i][i+d]) {
        			start = i;
                    end = i+d;
        		}
        	}
        }
        return s.substring(start, end+1);
    }
}
