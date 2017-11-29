package gogo;

public class GameOfLive {
	public static void main(String[] args) {
		GameOfLive g=new GameOfLive();
		g.gameOfLife(new int[][] {{1}});
	}
    public void gameOfLife(int[][] board) {
        if (board==null || board.length==0 || board[0]==null || board[0].length==0) return;
        int[][] next=new int[board.length][board[0].length];
        for (int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		next[i][j]=check(i,j,board);
        	}
        }
        for (int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		board[i][j]=next[i][j];
        		System.out.println(board[i][j]);
        	}
        }
        
    }
    private int check(int x, int y, int[][] board) {
    	int sum=0;
    	sum+=count(x-1,y,board);
    	sum+=count(x+1,y,board);
    	sum+=count(x-1,y-1,board);
    	sum+=count(x-1,y+1,board);
    	sum+=count(x,y-1,board);
    	sum+=count(x,y+1,board);
    	sum+=count(x+1,y-1,board);
    	sum+=count(x+1,y+1,board);
    	System.out.println("sum="+sum);
    	
    	int cur=board[x][y];
    	System.out.println(cur);
    	if (cur==1) {
    		if (sum<2 || sum>3) return 0;
    		else return 1;
    	}
    	if (sum==3) return 1;
    	return 0;
    	
    }
    
    private int count(int x, int y, int[][] board) {
    	if (x<0 || x>=board.length) return 0;
    	if (y<0 || y>=board[0].length) return 0;
    	return board[x][y];
    }
}
