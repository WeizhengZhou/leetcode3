package dp;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundRegion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0){
        	return;
        }
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
        	if(board[i][0]=='O' && !visited[i][0]){
        		bfs(i,0,board,visited);
        	}
        	if(board[i][board[0].length-1]=='O' && !visited[i][0]){
        		bfs(i,0,board,visited);
        	}
        }
        for(int i=0;i<board[0].length;i++){
        	if(board[0][i]=='O' && !visited[i][0]){
        		bfs(i,0,board,visited);
        	}
        	if(board[board.length-1][i]=='O' && !visited[i][0]){
        		bfs(i,0,board,visited);
        	}
        }
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]=='O' && !visited[i][j]){
        			board[i][j]='X';
        		}
        	}
        }
    }
    private class Pair{
    	int row;
    	int col;
    	Pair(int x, int y){
    		row=x;
    		col=y;
    	}
    }
    public void bfs(int row, int col, char[][] board,boolean[][] visited){
    	Queue<Pair> list=new LinkedList<Pair>();
    	list.add(new Pair(row,col));
    	while(!list.isEmpty()){
    		Pair p=list.poll();
    		visited[p.row][p.col]=true;
    		int r=p.row;
    		int c=p.col;
    		if(r-1>=0 && board[r-1][c]=='O'){
    			list.add(new Pair(r-1,c));
    		}
    		if(r+1<board.length && board[r+1][c]=='O'){
    			list.add(new Pair(r+1,c));
    		}
    		if(c-1>=0 && board[r][c-1]=='O'){
    			list.add(new Pair(r,c-1));
    		}
    		if(c+1<board[0].length && board[r][c+1]=='O'){
    			list.add(new Pair(r,c+1));
    		}
    	}

    }

}
