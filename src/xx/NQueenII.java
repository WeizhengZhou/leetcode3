package xx;

public class NQueenII {
	public int totalNQueens(int n) {
        if(n<=0){return 0;}
        int total=0;
        int[] buf=new int[n];
        for(int i=0;i<n;i++){
               buf[0]=i;
               total+=helper(1,buf,n);
        }
        return total;
    }
    private int helper(int row,int[] A,int n){
        if(row==n){return 1;}
        int count=0;
        for(int i=0;i<n;i++){
            A[row]=i;
            if(valid(A,row)){count+=helper(row+1,A,n);}
        }
        return count;
    }
    private boolean valid(int[] A,int row){
        for(int i=0;i<row;i++){
            if(A[i]==A[row])return false;
            if(Math.abs(A[i]-A[row])==Math.abs(i-row)){return false;}
        }
        return true;
    }
}
