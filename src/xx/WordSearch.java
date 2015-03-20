package xx;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if(board==null||board.length==0||board[0].length==0||word==null)return false;
		boolean[][] visited=new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(dfsHelper(i,j,0,board,word,visited))return true;
			}
		}
		return false;
	}
	private boolean dfsHelper(int x,int y,int index,char[][] board,String word, boolean[][] visited){
		if(index==word.length())return true;
		if(x<0||x>=board.length||y<0||y>=board[0].length) return false;
		if(board[x][y]!=word.charAt(index))return false;
		if(visited[x][y])return false;
		visited[x][y]=true;
		int[] dx=new int[]{1,-1,0,0};
		int[] dy=new int[]{0,0,1,-1};
		for(int i=0;i<4;i++){
			if(dfsHelper(x+dx[i],y+dy[i],index+1,board,word,visited))return true;
		}
		visited[x][y]=false;
		return false;
	}
}
