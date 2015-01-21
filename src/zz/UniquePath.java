package zz;

public class UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int uniquePaths(int m, int n) {
	     if(m==0 || n==0){
	    	 return 0;
	     }
	     int[][] ways=new int[m][n];
	     for(int i=0;i<m;i++){
	    	 ways[i][0]=1;
	     }
	     for(int j=0;j<n;j++){
	    	 ways[0][j]=1;
	     }
	     for(int i=1;i<m;i++){
	    	 for(int j=1;j<n;j++){
	    		 ways[i][j]=ways[i-1][j]+ways[i][j-1];
	    	 }
	     }
	     return ways[m-1][n-1];
	 }
	 

}
