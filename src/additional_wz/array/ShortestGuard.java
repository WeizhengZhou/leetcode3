package array;

import java.util.*;
public class ShortestGuard{
	public void guard(char[][] board){
		if(board == null || board.length == 0) return;
		Queue<Integer> row = new LinkedList<>();
		Queue<Integer> col = new LinkedList<>();
		int m = board.length;
		int n = board[0].length;
		for(int i=0;i<m;i++){//add all guards into queue
			for(int j=0;j<n;j++){
				if(board[i][j] == 'G'){
					row.add(i);
					col.add(j);
				}
			}
		}
		while(!row.isEmpty() && !col.isEmpty()){//bfs 
			int i = row.remove();
			int j = col.remove();
			System.out.println("i = " + i + ", j = " + j);

			update(board,i,j,i-1,j,row,col);//left			
			update(board,i,j,i+1,j,row,col);//right
			update(board,i,j,i,j-1,row,col);//up
			update(board,i,j,i,j+1,row,col);//down
		}	
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(board[i][j] + ",");
			}
			System.out.println();
		}	
	}
	private void update(char[][] board, int si, int sj, int ti, int tj, Queue<Integer> row, Queue<Integer> col){
		if(si <0 || si >= board.length || sj <0 || sj >= board[0].length)
			 return;	
		if(ti <0 || ti >= board.length || tj <0 || tj >= board[0].length) 
			return;
		if(board[ti][tj] == 'B' || board[ti][tj] == 'G')//destination is B or G, no update
			return;
		if(board[si][sj] == 'G')//source is G, destination is 1
			board[ti][tj] = '1';
		else if(board[ti][tj] == '0')//destination is empty, and first discover
	        board[ti][tj] = (char) (board[si][sj] +1);
		else if( (char) (board[si][sj] + 1) < board[ti][tj])//shorter path found
			board[ti][tj] = (char) (board[si][sj]+1);
		else 
			return;
		
		row.add(ti);
		col.add(tj);
	}
	public static void main(String[] args){
		char[][] board = new char[][]{{'G','0','0','0'},
									  {'0','B','B','0'},
									  {'0','B','0','0'}};
		ShortestGuard solu = new ShortestGuard();
		solu.guard(board);	
	}
}
