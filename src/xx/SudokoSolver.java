package xx;

import java.util.*;

public class SudokoSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SudokoSolver s=new SudokoSolver();
		char[][] ca=new char[][]{};
		//Arrays.deepToString()
		System.out.println(('1'-'0'));

	}
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
				if(isValid(x,y,i-'0',board)){
					board[x][y]=i;
					if(solveHelper(x,y+1,board)) return true;
					
				}
				board[x][y]='.';
			}		
			return false;
		}

		private boolean isValid(int x, int y, int d, char[][] board){
			//row isValid
			Set<Integer> rowSet=new HashSet<>();
			for(int j=0;j<9;j++){
				if(board[x][j]!='.'){
					rowSet.add(board[x][j]-'0');
				}
			}
			if(rowSet.contains(d)){return false;}
			//validate col
			Set<Integer> colSet=new HashSet<>();
	                for(int i=0;i<9;i++){
	                        if(board[i][y]!='.'){ 
	                               colSet.add(board[i][y]-'0');
	                        }
	                } 
	        if(colSet.contains(d)){return false;}

			//validate Cube
	        Set<Integer> cubeSet=new HashSet<>();
	                for(int i=0;i<3;i++){
	                   for(int j=0;j<3;j++){
	                     if(board[x/3+i][y/3+j]!='.'){ 
	                               cubeSet.add(board[x/3+i][y/3+j]-'0');
	                       }
	                    } 
		      }
	        if(cubeSet.contains(d)){return false;}
	        return true;
	    }


	

}
