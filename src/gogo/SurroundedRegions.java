package gogo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board==null || board.length<3 || board[0]==null || board[0].length<3) return;
        int row = board.length;
        int col = board[0].length;
        boolean[][] isO = new boolean[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i=0;i<col;i++) {
        	if (board[0][i]=='O' && !isO[0][i]) {
        		expand(0,i,board,isO,visited);
        	}
        	if (board[row-1][i]=='O' && !isO[row-1][i]) {
        		expand(row-1,i,board,isO,visited);
        	}
        }
        for (int i=0;i<row;i++){
        	if (board[i][0]=='O' && !isO[i][0]) {
        		expand(i,0,board,isO,visited);
        	}
        	if (board[i][col-1]=='O' && !isO[i][col-1]) {
        		expand(i,col-1,board,isO,visited);
        	}
        }
        for (int i=1;i<row-1;i++) {
        	for (int j=1;j<col-1;j++) {
        		if (board[i][j]=='O' && !isO[i][j]) {
        			board[i][j] = 'X';
        		}
        	}
        }
    }
	public void expand(int i, int j, char[][] board, boolean[][] check, boolean[][] visited){//zz private method!
		Queue<Integer> row=new LinkedList<Integer>();
		Queue<Integer> col=new LinkedList<Integer>();
		row.add(i);
		col.add(j);
		while(!row.isEmpty()){
			
			int x=row.poll();//zz remove
			int y=col.poll();
			//System.out.println(x);
			//if(x>=0 && x<board.length && y>=0 && y<board[0].length){

				//if(!visited[x][y] && board[x][y]=='O'){
			if(x<0 || x>=board.length || y<0 || y>=board[0].length){
				continue;
			}
			if(visited[x][y] || board[x][y]=='X'){
				continue;
			}
					visited[x][y]=true;
					check[x][y]=true;
					row.add(x-1);
					row.add(x+1);
					row.add(x);
					row.add(x);
					col.add(y);
					col.add(y);
					col.add(y-1);
					col.add(y+1);
			//	}
			//}
		}
	}
}
