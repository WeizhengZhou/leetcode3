package gogo;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1==null || s2==null ||s3==null) return false;
        if (s3.length()!=s1.length()+s2.length()) return false;
        boolean[][] isIn = new boolean[s1.length()+1][s2.length()+1];
        isIn[0][0] = true;
        for (int i=0;i<s1.length();i++) {
        	isIn[i+1][0]=s1.substring(0, i+1).equals(s3.substring(0,i+1));
        }
        for (int i=0;i<s2.length();i++) {
        	isIn[0][i+1]=s2.substring(0, i+1).equals(s3.substring(0,i+1));
        }
        for (int i=1;i<=s1.length();i++) {
        	char c1 = s1.charAt(i-1);
        	for(int j=1;j<=s2.length();j++) {
        		char c2 = s2.charAt(j-1);
        		char c3 = s3.charAt(i+j-1);
        		if (c1==c3 && isIn[i-1][j] || c2==c3 && isIn[i][j-1]) {
        			isIn[i][j] = true;
        		}
        	}
        }
        return isIn[s1.length()][s2.length()];
    }
}
