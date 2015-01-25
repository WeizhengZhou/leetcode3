package zz;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isValidSudoku(char[][] board) {
		  if(board==null || board.length==0 || board[0].length==0 ){
			  return false;
		  }
		  for(int i=0;i<9;i++){
			  if(!checkCol(i,board)){
				  return false;
			  }
		  }
		  for(int i=0;i<9;i++){
			  if(!checkRow(i,board)){
				  return false;
			  }
		  }
		  for(int i=0;i<3;i++){
			  for(int j=0;j<3;j++){
				  if(!checkCube(i,j,board)){
					  return false;
				  }
			  }			  
		  }
		  return true;
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
