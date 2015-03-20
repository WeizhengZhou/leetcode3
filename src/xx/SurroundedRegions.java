package xx;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if(board==null || board.length==0 || board[0].length==0){return;}
		boolean[][] isEdgeO=new boolean[board.length][board[0].length];
		int n=board.length;
		int m=board[0].length;
		for(int i=0;i<n;i++){
		    if(!isEdgeO[i][0]&&board[i][0]=='O'){bfsHelper(i,0,board,isEdgeO);}
		}
		for(int i=0;i<n;i++){
		    if(!isEdgeO[i][m-1]&&board[i][m-1]=='O'){bfsHelper(i,m-1,board,isEdgeO);}
		}
		for(int j=0;j<m;j++){
		    if(!isEdgeO[0][j]&&board[0][j]=='O'){bfsHelper(0,j,board,isEdgeO);}
		}
		for(int j=0;j<m;j++){
		    if(!isEdgeO[n-1][j]&&board[n-1][j]=='O'){bfsHelper(n-1,j,board,isEdgeO);}
		}
		for(int i=0;i<n;i++){
		    for(int j=0;j<m;j++){
		        if(!isEdgeO[i][j]&&board[i][j]=='O'){board[i][j]='X';}
		    }
		}
	}
	private void bfsHelper(int x, int y, char[][] board, boolean[][] isO){
	    if(x<0 || x>=board.length || y<0 || y>=board[0].length){return;}
	    if(isO[x][y] || board[x][y]!='O'){return;}
	    int[] dx=new int[]{-1,1,0,0};
	    int[] dy=new int[]{0,0,-1,1};
	    Queue<Integer> queueX=new LinkedList<>();
	    Queue<Integer> queueY=new LinkedList<>();
	    queueX.add(x);
	    queueY.add(y);
	    while(!queueX.isEmpty()){
	        int curX=queueX.poll();
	        int curY=queueY.poll();
	        if(curX<0 || curX>=board.length || curY<0 || curY>=board[0].length){continue;}
	        if(isO[curX][curY] || board[curX][curY]!='O'){continue;}
	        isO[curX][curY]=true;
	        for(int i=0;i<4;i++){
	            queueX.add(curX+dx[i]);
	            queueY.add(curY+dy[i]);
	        }
	    }
	}
}
