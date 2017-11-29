package gogo;

public class RegularExpressionMatch {
	public static void main(String[] args) {
		RegularExpressionMatch r = new RegularExpressionMatch();
		System.out.println(r.isMatch("",".*"));
	}
	public boolean isMatch(String s, String p) {
        if ((s==null && p==null) || (s.length()==0 && p.length() ==0)) return true;
        if (s==null || p==null || p.length()==0) return false;
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] match = new boolean[sLen+1][pLen+1];
        match[0][0] = true;
        match[0][1] = false;
        for(int j=2;j<=pLen;j++){
        	char pChar = p.charAt(j-1);
        	if (pChar == '*') match[0][j] = match[0][j-2];
        	System.out.println("m[0][" + j+"]="+match[0][j]);
        }
        for(int i=1;i<=sLen;i++) {
        	for (int j=1;j<=pLen;j++) {
        		char sChar = s.charAt(i-1);
        		char pChar = p.charAt(j-1);
        		if (sChar == pChar || pChar=='.') {
        			match[i][j]=match[i-1][j-1];
        		}       		
        		if (pChar == '*') {
        			if (j>=2 && match[i][j-2]) match[i][j] = true;
        			else if (j>=2 && (sChar == p.charAt(j-2) || p.charAt(j-2) == '.' )) {match[i][j] =match[i][j-1] || match[i-1][j];}
        		}
        		System.out.println("m[" +i +"][" + j+"]="+match[i][j]);
        	}
        }
        return match[sLen][pLen];
    }
}
