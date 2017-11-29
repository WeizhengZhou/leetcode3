package gogo;

public class EditDistance {
	public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null || word1.length() ==0 && word2.length() ==0) return 0;
        if (word1==null ||word1.length()==0) return word2.length();
        if (word2==null ||word2.length()==0) return word1.length();
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dist = new int[l1+1][l2+1];
        dist[0][0] = 0;
        for (int i=0;i<=l1;i++) {
        	dist[i][0] = i;
        }
        for (int j=0;j<=l2;j++) {
        	dist[0][j] = j;
        }
        for (int i=1;i<=l1;i++) {
        	char c1 = word1.charAt(i-1);
        	for (int j=1;j<=l2;j++) {
        		char c2 = word2.charAt(j-1);
        		int change = c1==c2 ? 0:1;
        		change = change + dist[i-1][j-1];
        		int addOrRe = Math.min(dist[i-1][j], dist[i][j-1]) + 1;
        		dist[i][j] = Math.min(addOrRe, change);
        	}
        }
        return dist[l1][l2];
    }
}
