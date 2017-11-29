package gogo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSearchII {
	// not pass OJ, need use Trie to optimize
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> list=new HashSet<> ();
        if (board == null || board.length == 0 || board[0]==null || board[0].length==0 || words ==null || words.length == 0) return new LinkedList<String> ();
        int m = board.length;
        int n = board[0].length;
        
    	for (int i=0;i<board.length;i++) {
        	for (int j=0;j<board[0].length;j++) {
        		for (int k=0;k<words.length;k++) {
        			if (!list.contains(words[k])) {
        				char c=board[i][j];
                		if (c==words[k].charAt(0) && helper(i, j, 0, board, words[k], new boolean[m][n])) {
                			list.add(words[k]);
                		}
        			}		
        		}
        	}
        }  
        return new LinkedList<String> (list);
    }
	public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0]==null || board[0].length==0 || word ==null || word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;
        for (int i=0;i<board.length;i++) {
        	for (int j=0;j<board[0].length;j++) {
        		if (helper(i, j, 0, board, word, new boolean[m][n])) {
        			return true;
        		}
        	}
        }
        return false;
    }
	
	private boolean helper(int x, int y, int index, char[][] board, String word, boolean[][] used) {
		if (index >= word.length()) return true;
		if (x<0 || x>=board.length) return false;
		if (y<0 || y>=board[0].length) return false;	
		if (used[x][y]) return false;
		char c = board[x][y];
		if (c!= word.charAt(index)) {
			return false;
		}
		used[x][y] = true;
		if (
			helper(x-1,y,index+1,board,word,used) || helper(x+1,y,index+1,board,word,used)
			|| helper(x,y-1,index+1,board,word,used) || helper(x,y+1,index+1,board,word,used)
		) {
			return true;
		}
		used[x][y] = false;
		return false;
	}
}
