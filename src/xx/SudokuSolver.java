package xx;
import java.util.*;
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		if(board==null || board.length==0 || board[0].length==0){
			return;
		}
		solveHelper(0,0,board);
	}

	private boolean solveHelper(int x, int y, char[][] board){
		if(x==board.length)return true;
		if(y==board[0].length){
			return solveHelper(x+1,0,board);	
		}
		if(board[x][y]!='.'){
			return solveHelper(x,y+1,board);
		}	
		for(char i='1';i<='9';i++){
			if(isValid(x,y,i,board)){
				board[x][y]=i;
				if(solveHelper(x,y+1,board)) {return true;}
				else{board[x][y]='.';}

			}

		}		
		return false;
	}

	private boolean isValid(int x, int y, char cur, char[][] board){
		//row isValid

		Set<Character> rowSet=new HashSet<>();
		for(int j=0;j<9;j++){
			if(board[x][j]!='.'){
				rowSet.add(board[x][j]);
			}
		}
		if(rowSet.contains(cur)){return false;}
		//validate col
		Set<Character> colSet=new HashSet<>();
		for(int i=0;i<9;i++){
			if(board[i][y]!='.'){ 
				colSet.add(board[i][y]);
			}
		} 
		if(colSet.contains(cur)){return false;}

		//validate Cube
		Set<Character> cubeSet=new HashSet<>();
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[x/3*3+i][y/3*3+j]!='.'){ 
					cubeSet.add(board[x/3*3+i][y/3*3+j]);
				}
			} 
		}
		if(cubeSet.contains(cur)){return false;}
		return true;
	}
}
