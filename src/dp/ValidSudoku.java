package dp;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValidSudoku(char[][] board) {
        if(board==null){
        	return false;
        }
        for(int i=0;i<9;i++){
        	if(!checkRow(i,board)){
        		return false;
        	}
        	if(!checkCol(i,board)){
        		return false;
        	}
        }
        for(int i=0;i<3;i++){
        	for(int j=0;j<3;j++){
        		if(!checkSq(i,j,board)){
        			return false;
        		}
        	}
        }
        return true;
    }
    
    public boolean checkRow(int index, char[][] board){
    	Set<Character> s=new HashSet<Character>();
    	for(int i=0;i<9;i++){
    		char c=board[index][i];
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
    	return true;
    }
    
    public boolean checkCol(int index, char[][] board){
    	Set<Character> s=new HashSet<Character>();
    	for(int i=0;i<9;i++){
    		char c=board[i][index];
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
    	return true;
    }
    public boolean checkSq(int x, int y, char[][] board){
    	Set<Character> s=new HashSet<Character>();
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
	    		char c=board[i+x*3][j+y*3];
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
    	}
    	return true;
    }
}
