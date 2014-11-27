package dp;

import java.util.HashSet;
import java.util.Set;

public class SolveSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	char[][] board = {{'5','3','.','.','7','.','.','.','.'},
    			{'6','.','.','1','9','5','.','.','.'},
    			{'.','9','8','.','.','.','.','6','.'},
    			{'8','.','.','.','6','.','.','.','3'},
    			{'4','.','.','8','.','3','.','.','1'},
    			{'7','.','.','.','2','.','.','.','6'},
    			{'.','6','.','.','.','.','2','8','.'},
    			{'.','.','.','4','1','9','.','.','5'},
    			{'.','.','.','.','8','.','.','7','9'}};
//    	System.out.println(Character.getNumericValue(boad[0][1])); 
    	SolveSudoku solution = new SolveSudoku();
    	solution.solveSudoku(board);;
    	solution.print(board);
    	System.out.println((char)1);
	}
	
	private void print(char[][] board){
    	for(char[] row : board){
    		for(char c : row){
    			System.out.print(c + ", ");
    		}
    		System.out.println();
    	}
    }
	
    public void solveSudoku(char[][] board) {
        dfs(0,0,board);
        return;
    }
    
    public boolean dfs(int x, int y, char[][] board){
    	if(y==9){
    		x=x+1;
    		y=0;
    	}
    	if(x>=9){
    		return true;
    	}

    	if(board[x][y]!='.'){
    		return dfs(x,y+1,board);
    	}
    	else{
    		for(char c='1';c<='9';c++){
    			board[x][y]=c;
    			if(isValid(x,y,board) && dfs(x,y+1,board)){
    				return true;
    			}
    		}
    		board[x][y]='.';
    	}
    	return false;
    }
    
    public boolean isValid(int x,int y, char[][] board){
    	Set<Character> s=new HashSet<Character>();
    	for(int i=0;i<9;i++){
    		char c=board[x][i];
    		if(c=='.'){
    			continue;
    		}
    		else{
    			if (s.contains(c)){
    				return false;
    			}
    			else{
    				s.add(c);
    			}
    		}
    	}
    	Set<Character> sC=new HashSet<Character>();
    	for(int i=0;i<9;i++){
    		char c=board[i][y];
    		if(c=='.'){
    			continue;
    		}
    		else{
    			if (sC.contains(c)){
    				return false;
    			}
    			else{
    				sC.add(c);
    			}
    		}
    	}
    	Set<Character> sS=new HashSet<Character>();
    	int a=x/3;
    	int b=y/3;
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
	    		char c=board[i+a*3][j+b*3];
	    		if(c=='.'){
	    			continue;
	    		}
	    		else{
	    			if (sS.contains(c)){
	    				return false;
	    			}
	    			else{
	    				sS.add(c);
	    			}
	    		}
    		}
    	}
    	return true;
    }
}
