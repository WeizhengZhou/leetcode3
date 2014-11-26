package dp;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundRegion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       SurroundRegion s=new SurroundRegion();
       long curTime = System.currentTimeMillis();
//       s.solve(new char[][]{{'X','O','X','O','X','O'},
//    		   				{'O','X','O','X','O','X'},
//    		   				{'X','O','X','O','X','O'},
//    		   				{'O','X','O','X','O','X'}});
       
       s.solve(new char[][]{{'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},
    		   {'X','O','O','O','O','O','O','O'},							
  				});
       long endTime = System.currentTimeMillis();
       System.out.println("Time = " + (endTime - curTime));
	}
	char[][] board=null;
	boolean[][] visited=null;
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0){
        	return;
        }
        this.visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
        	if(board[i][0]=='O' && !visited[i][0]){
        		bfs(i,0,board);
        	}
        	if(board[i][board[0].length-1]=='O' && !visited[i][board[0].length-1]){
        		bfs(i,board[0].length-1,board);
        	}
        }
        for(int i=0;i<board[0].length;i++){
        	if(board[0][i]=='O' && !visited[0][i]){
        		bfs(0,i,board);
        	}
            if(board[board.length-1][i]=='O' && !visited[board.length-1][i]){
        		bfs(board.length-1,i,board);
        	}
        }
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]=='O' && !visited[i][j]){
        			board[i][j]='X';
        		}
        	}
        }
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		System.out.print(board[i][j]+" ");
        	}
        	System.out.println(" ");
        }
        
    }
    private class Pair{
    	int row;
    	int col;
    	Pair(int x, int y){
    		row=x;
    		col=y;
    	}
    }
    public void bfs(int row, int col, char[][] board){
    	System.out.println("row = " + row + ", col = " + col);
    	Queue<Pair> list=new LinkedList<Pair>();
    	list.add(new Pair(row,col));
    	while(!list.isEmpty()){
    		Pair p=list.poll();
    		visited[p.row][p.col]=true;
    		int r=p.row;
    		int c=p.col;
//    		System.out.println("r = " + r + ", c = " + c);
    		if(r-1>=0 && board[r-1][c]=='O' && !visited[r-1][c]){
    			list.add(new Pair(r-1,c));
    			//System.out.println("add row "+(r-1)+" col "+(c));
    		}
    		if(r+1<board.length && board[r+1][c]=='O'&& !visited[r+1][c]){
    			list.add(new Pair(r+1,c));
    		}
    		if(c-1>=0 && board[r][c-1]=='O'&& !visited[r][c-1]){
    			list.add(new Pair(r,c-1));
    		}
    		if(c+1<board[0].length && board[r][c+1]=='O'&& !visited[r][c+1]){
    			list.add(new Pair(r,c+1));
    		}
    	}
    }
    // public void bfs(int i, int j, char[][] board){
    // 	Queue<Integer> row = new LinkedList<Integer>();
    // 	Queue<Integer> col = new LinkedList<Integer>();
    	
    // 	row.add(i);
    //     col.add(j);
    // 	while(!row.isEmpty()){
    // 		int r = row.remove();
    // 		int c = col.remove();
    // 		if(r<0||r>=board.length||c<0||c>=board[0].length)
    // 		    continue;
    // 		if(board[r][c] == 'X')
    // 		    continue;
    // 		if(visited[r][c] == true)
    // 		    continue;
    // 		visited[r][c] = true;
    // 		row.add(r-1);col.add(c);
    // 		row.add(r+1);col.add(c);
    // 		row.add(r);col.add(c-1);
    // 		row.add(r);col.add(c+1);
    // 	}
    // }
//    // public void bfs(int i, int j, char[][] board){
//    // 	Queue<Pair> queue = new LinkedList<Pair>();
//    //     queue.add(new Pair(i,j));
//    // 	while(!queue.isEmpty()){
//    // 		Pair cur = queue.remove();
//    // 		int r = cur.row;
//    // 		int c = cur.col;
//    // 		if(r<0||r>=board.length||c<0||c>=board[0].length)
//    // 		    continue;
//    // 		if(board[r][c] == 'X')
//    // 		    continue;
//    // 		if(visited[r][c] == true)
//    // 		    continue;
//    // 		visited[r][c] = true;
//    
//    // 		queue.add(new Pair(r-1,c));
//    // 		queue.add(new Pair(r+1,c));
//    // 		queue.add(new Pair(r,c-1));
//    // 		queue.add(new Pair(r,c+1));
//    // 	}
//    // }

}
