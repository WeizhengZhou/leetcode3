import java.util.*;
            
/*public class SudokuSolver{
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
		for(int i=1;i<=9;i++){
			if(isValid(x,y,i,board)){
				board[x][y]=(char)(i+'0');
				if(solveHelper(x,y+1,board)) return true;
			}	
		}		

		return false;
	}

	private boolean isValid(int x, int y, int i, char[][] board){
		//row isValid
		Set<Integer> rowSet=new HashSet<>();
		for(int j=0;j<9;j++){
			if(board[x][j]!='.'){
				if( rowSet.contains(board[x][j]-'0')){
					return false;
				}
				else{rowSet.add(board[x][j]-'0');}
			}
		}

		//validate col
		Set<Integer> colSet=new HashSet<>();
                for(int i=0;i<9;i++){
                        if(board[i][y]!='.'){ 
                                if( colSet.contains(board[i][y]-'0')){
                                        return false;
                                }
                                else{colSet.add(board[i][y]-'0');}
                        }
                } 

		//validate Cube
		Set<Integer> cubeSet=new HashSet<>();
                for(int i=0;i<3;i++){
                   for(int j=0;j<3;j++){
                     if(board[x/3+i][y/3+j]!='.'){ 
                                if( cubeSet.contains(board[x/3+i][y/3+j]-'0')){
                                        return false;
                                }
                                else{cubeSet.add(board[x/3+i][y/3+j]-'0');}
                        }
                    } 
	            }
        return true;
    }
}*/
