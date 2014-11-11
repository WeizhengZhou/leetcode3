package dp;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch w=new WordSearch();
		
		char[][] board=new char[][]{{'a'}};
		System.out.println(w.wordSearch(board, "ab"));

	}
	
	public boolean wordSearch(char[][] board, String s){
		boolean[][] used=new boolean[board.length][board[0].length];
		for(int i=0; i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(helper(i,j,board,used,s,0)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean helper(int x, int y, char[][] board, boolean[][] used, String s, int index){
		if(index==s.length()){
			return true;
		}
		if (x<0||x>=board.length||y<0||y>=board[0].length){
			return false;
		}
		if(board[x][y]!=s.charAt(index)){
			return false;
		}
		if(used[x][y]){
			return false;
		}
		used[x][y]=true;
		if(helper(x-1,y,board,used,s,index+1)||helper(x+1,y,board,used,s,index+1)||helper(x,y-1,board,used,s,index+1)||helper(x,y+1,board,used,s,index+1)){
			return true;
		}
		used[x][y]=false;
		return false;
	}


}
