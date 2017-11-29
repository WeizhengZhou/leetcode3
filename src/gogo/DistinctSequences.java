package gogo;

public class DistinctSequences {
    public int numDistinct(String s, String t) {
        if (s==null || t==null || s.length()==0 || t.length() ==0) return 0;
        if (s.length()<t.length()) return 0;
        int[][] ways = new int[s.length()+1][t.length()+1];
        for (int i=0;i<=s.length();i++) ways[i][0]=1;
        for (int i=1;i<=s.length();i++) {
        	char sChar = s.charAt(i-1);
        	for (int j=1;j<=t.length();j++) {
        		char tChar = t.charAt(j-1);
        		ways[i][j] = ways[i-1][j];
        		if (sChar==tChar) {
        			ways[i][j] +=ways[i-1][j-1];
        		}
        	}
        }
        return ways[s.length()][t.length()];
    }
}
