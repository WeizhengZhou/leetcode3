package gogo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int count=0;
        boolean[][] used=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
        	for (int j=0;j<grid[0].length;j++) {
        		if (grid[i][j]=='1' && !used[i][j]) {
        			count++;
        			expand(i,j,grid,used);
        		}
        	}
        }
        return count;
    }
    
    private void expand(int x, int y, char[][] grid, boolean[][] used){
    	Queue<Integer> rows=new LinkedList<> ();
    	Queue<Integer> cols=new LinkedList<> ();
    	rows.add(x);
    	cols.add(y);
    	while(!rows.isEmpty()) {
    		int i=rows.poll();
    		int j=cols.poll();
    		if (i<0 || i>=grid.length||j<0||j>=grid[0].length) continue;
        	if (used[i][j] || grid[i][j]!='1') continue;
        	used[i][j]=true;
        	rows.add(i+1);
        	cols.add(j);
        	rows.add(i-1);
        	cols.add(j);
        	rows.add(i);
        	cols.add(j-1);
        	rows.add(i);
        	cols.add(j+1);
    	}
    }
}
