package xx;
import java.util.*;
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if(board==null || board.length==0 || board[0].length==0){return false;}
		for(int i=0;i<9;i++){
			if(!checkRow(i,board)||!checkCol(i,board)) return false;
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(!checkCube(i,j,board)) return false;
			}
		}
		return true;
	}
	private boolean checkRow(int row,char[][] board){
		BitSet set=new BitSet();
		for(int i=0;i<9;i++){
			if(board[row][i]=='.')continue;
			int cur=board[row][i]-'0';
			if(set.get(cur))return false;
			set.set(cur);
		}
		return true;
	}
	private boolean checkCol(int col,char[][] board){
		BitSet set=new BitSet();
		for(int i=0;i<9;i++){
			if(board[i][col]=='.')continue;
			int cur=board[i][col]-'0';
			if(set.get(cur))return false;
			set.set(cur);
		}
		return true;
	}
	private boolean checkCube(int x,int y,char[][] board){
		BitSet set=new BitSet();
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[i+3*x][j+3*y]=='.')continue;
				int cur=board[i+3*x][j+3*y]-'0';
				if(set.get(cur))return false;
				set.set(cur);   
			}
		}
		return true;
	}
}
