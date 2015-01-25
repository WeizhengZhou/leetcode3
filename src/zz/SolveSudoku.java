package zz;

import java.util.HashSet;
import java.util.Set;

public class SolveSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void solveSudoku(char[][] board) {
		if(board==null){
			return;
		}
		helper(0,0,board);
	}
	
	public boolean helper(int x, int y, char[][] board){
		if(x==9){
			return true;
		}
		if(y==9){
			return helper(x+1,0,board);
		}
		if(board[x][y]!='.'){
			return helper(x,y+1,board);
		}
		for(char c='1';c<='9';c++){
			board[x][y]=c;
			if(checkRow(x,board) && checkCol(y,board)&&checkCube(x/3,y/3,board)){
				if(helper(x,y+1,board))
					return true;
			}
			board[x][y]='.';
		}
		return false;
	}
	
	public boolean checkRow(int row, char[][] board){
		Set<Character> set=new HashSet<Character>();
		for(int i=0;i<9;i++){
			char cur=board[row][i];
			if(cur!='.'){
				if(set.contains(cur)){
					return false;
				}
				set.add(cur);
			}
		}
		return true;
	}
	public boolean checkCol(int col, char[][] board){
		Set<Character> set=new HashSet<Character>();
		for(int i=0;i<9;i++){
			char cur=board[i][col];
			if(cur!='.'){
				if(set.contains(cur)){
					return false;
				}
				set.add(cur);
			}
		}
		return true;
	}
	
	public boolean checkCube(int row, int col, char[][] board){
		Set<Character> set=new HashSet<Character>();
		for(int i=row*3;i<row*3+3;i++){
			for(int j=col*3;j<col*3+3;j++){
				char cur=board[i][j];
				if(cur!='.'){
					if(set.contains(cur)){
						return false;
					}
					set.add(cur);
				}
			}
		}
		return true;
	}

}
