package gogo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SudokuSolver {
	public static void main(String[] args) {
		//System.out.println('3'-'1');
		Set<Character> set = new HashSet<> ();
    	for (char i='1';i<='9';i++){
    		set.add(i);
    	}
    	set.remove('9');
    	//Iterator it=set.iterator();
    	//while(it.hasNext()) {
    		//System.out.println(it.next());
    		
    	//}
    	//for(char c:set) System.out.println(c);
    	SudokuSolver s = new SudokuSolver();
    	char[][] board = {
    			"..9748...".toCharArray(),
    			"7........".toCharArray(),
    			".2.1.9...".toCharArray(),
    			"..7...24.".toCharArray(),
    			".64.1.59.".toCharArray(),
    			".98...3..".toCharArray(),
    			"...8.3.2.".toCharArray(),
    			"........6".toCharArray(),
    			"...2759..".toCharArray()};
    	s.solveSudoku(board);
    	for(int i=0;i<9;i++) {
    		System.out.println(new String(board[i]));
    	}
	}
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0] == null || board[0].length != 9) return;
        sudokuHelper(0,0,board);
    }
    
    public boolean sudokuHelper(int x, int y, char[][] board) {
    	System.out.println();
    	for(int i=0;i<9;i++) {
    		System.out.println(new String(board[i]));
    	}
    	if (x==9) return true;
    	if (y==9) return sudokuHelper(x+1,0,board);
    	char c = board[x][y];
    	if (c!='.') return sudokuHelper(x,y+1,board);
    	Set<Character> set = findAvailable(x,y,board);
    	if (set.isEmpty()) return false;
    	for(char i:set) {
    		board[x][y] = i;
    		if (sudokuHelper(x,y+1,board)) return true;
    	}
    	board[x][y]='.';
    	return false;
    }
    private Set<Character> findAvailable(int x, int y, char[][] board) {
    	Set<Character> set = new HashSet<> ();
    	for (char i='1';i<='9';i++){
    		set.add(i);
    	}
    	for (int j=0;j<9;j++) {
    		char c = board[x][j];
    		if (c=='.') continue;
    		set.remove(c);
    	}
    	for(int i=0;i<9;i++) {
    		char c = board[i][y];
    		if (c=='.') continue;
    		set.remove(c);
    	}
    	int xIndex = x/3;
    	int yIndex = y/3;
    	for (int i=xIndex*3; i<3+xIndex*3;i++) {
    		for(int j=yIndex*3; j<3+yIndex*3;j++) {
    			char c = board[i][j];
        		if (c=='.') continue;
        		set.remove(c);
    		}
    	}
    	System.out.println("x="+x+",y="+y);
    	for(char c:set) System.out.println(c);
    	return set;
    }
}
