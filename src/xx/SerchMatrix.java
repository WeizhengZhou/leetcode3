package xx;

public class SerchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
	    if(matrix==null||matrix.length==0||matrix[0].length==0)return false;
	    int row=findRow(0,matrix.length-1,matrix,target);
	    if(row==-1)return false;
	    return searchRow(0,matrix[0].length-1,matrix,row,target);
	}
	private int findRow(int l,int r,int[][] matrix,int target){
	    if(l>r)return -1;
	    if(l==r)return l;
	    int m=l+(r-l)/2;
	    if(target>=matrix[m][0] && target<matrix[m+1][0]){return m;}
	    else if(target<matrix[m][0]){
	        return findRow(l,m-1,matrix,target);
	    }
	    else{
	        return findRow(m+1,r,matrix,target);
	    }
	}
	private boolean searchRow(int l,int r,int[][] matrix,int row,int target){
	    if(l>r){return false;}
	    if(l==r){return matrix[row][l]==target;}
	    int m=l+(r-l)/2;
	    if(matrix[row][m]==target){return true;}
	    else if(target<matrix[row][m]){return searchRow(l,m-1,matrix,row,target);}
	    else{return searchRow(m+1,r,matrix,row,target);}
	}
}
