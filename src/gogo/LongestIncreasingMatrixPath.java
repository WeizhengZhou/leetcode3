package gogo;

import java.util.HashSet;
import java.util.Set;

public class LongestIncreasingMatrixPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null || matrix.length==0 ||  matrix[0]==null || matrix[0].length==0) return 0;
        int max=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] len=new int[n][m];
        for (int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		max=Math.max(max, helper(i,j,len,matrix,Long.MIN_VALUE, new HashSet<int[]> ()));
        	}
        }
        return max;
    }
    
    private int helper(int x, int y, int[][] cache, int[][] matrix, long pre, Set<int[]> used) {
    	if (x<0 || x>=matrix.length || y<0 || y>=matrix[0].length) return 0;
    	if (matrix[x][y]<=pre) return 0;
    	int[] index=new int[] {x,y};
    	if (used.contains(index)) return 0;
    	if (cache[x][y]>0) return cache[x][y];
    	int max=0;
    	used.add(index);
    	int cur=matrix[x][y];
    	max=Math.max(max, helper(x-1,y,cache,matrix,cur,used));
    	max=Math.max(max, helper(x+1,y,cache,matrix,cur,used));
    	max=Math.max(max, helper(x,y+1,cache,matrix,cur,used));
    	max=Math.max(max, helper(x,y-1,cache,matrix,cur,used));
    	cache[x][y]=max+1;
    	used.remove(index);
    	return max+1;
    }
}
