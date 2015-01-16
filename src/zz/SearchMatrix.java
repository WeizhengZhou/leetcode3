package zz;

public class SearchMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0){
			return false;
		}
		int row=findRow(0,matrix.length-1,matrix,target);
		if(row!=-1 && searchRow(0,matrix[0].length-1,row,matrix,target)){
			return true;
		}
		return false;
	}
	
	public int findRow(int l, int r,int[][] matrix, int target){
		if(l>r){
			return -1;
		}
		if(l==r){
			return matrix[l][0]<=target?l:-1;
		}
		int m=l+(r-l)/2;
		if(target>=matrix[m][0]&&target<matrix[m+1][0]){
			return m;
		}
		if(target<matrix[m][0]){
			return findRow(l,m-1,matrix,target);
		}
		else{
			return findRow(m+1,r,matrix,target);
		}
	}
	
	public boolean searchRow(int l, int r, int row, int[][] matrix, int target){
		if(l>r){
			return false;
		}
		if(l==r){
			return matrix[row][l]==target;
		}
		int m=l+(r-l)/2;
		if(matrix[row][m]==target){
			return true;
		}
		if(matrix[row][m]>target){
			return searchRow(l,m-1,row,matrix,target);
		}
		else{
			return searchRow(m+1,r,row,matrix,target);
		}
	}

}
