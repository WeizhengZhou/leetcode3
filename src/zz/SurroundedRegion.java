package zz;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SurroundedRegion s=new SurroundedRegion();
		s.solve(new char[][]{{'O','O'},{'O','O'}});

	}
	
	public void solve(char[][] board) {
		if(board==null || board.length==0 || board[0].length==0){
			return;
		}
		boolean[][] visited=new boolean[board.length][board[0].length];
		boolean[][] check=new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			
				if(!visited[i][0] && board[i][0]=='O'){
					bfs(i,0,visited,board,check);
				}
				if(!visited[i][board[0].length-1] && board[i][board[0].length-1]=='O'){
					bfs(i,board[0].length-1,visited,board,check);
				}
			
		}
		for(int j=0;j<board[0].length;j++){
			if(!visited[0][j] && board[0][j]=='O'){
				bfs(0,j,visited,board,check);
			}
			if(!visited[board.length-1][j] && board[board.length-1][j]=='O'){
				bfs(board.length-1,j,visited,board,check);
			}
		}
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(!check[i][j] && board[i][j]=='O'){
					board[i][j]='X';
				}
			}
		}
	}

	public void bfs(int i, int j, boolean[][] visited, char[][] board, boolean[][] check){
		Queue<Integer> row=new LinkedList<Integer>();
		Queue<Integer> col=new LinkedList<Integer>();
		row.add(i);
		col.add(j);
		while(!row.isEmpty()){
			
			int x=row.poll();
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
