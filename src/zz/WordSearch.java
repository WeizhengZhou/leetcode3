package zz;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0 || board[0].length==0 || word==null || word.length()==0){
        	return false;
        }
        boolean[][] isVisited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]==word.charAt(0)){
        			if(dfs(0,i,j,board,word,isVisited)){
        				return true;
        			}       				
        		}
        	}
        }
        return false;
    }
	
	boolean dfs(int index,int i,int j, char[][] board, String word, boolean[][] isVisited){
		if(index>=word.length()){
			return true;
		}
		if(i<0 || i>=board.length || j<0 || j>=board[0].length){
			return false;
		}
		if(word.charAt(index)!=board[i][j]){
			return false;
		}
		if(isVisited[i][j]){
			return false;
		}
		isVisited[i][j]=true;
		if(dfs(index+1,i-1,j,board,word,isVisited)||dfs(index+1,i+1,j,board,word,isVisited)||dfs(index+1,i,j+1,board,word,isVisited)||dfs(index+1,i,j-1,board,word,isVisited)){
			return true;
		}
		isVisited[i][j]=false;
		return false;
	}

}
