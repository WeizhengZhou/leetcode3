package gogo;

public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length ==0) return false;
        int row = searchRow(0, matrix.length - 1, matrix, target);
        if (row<0) return false;
        return searchCol(0,matrix[0].length - 1, matrix[row], target);
    }
	
	private int searchRow(int l, int r, int[][] matrix, int target) {
		if (l>r) return -1;
		int n = matrix[0].length;
		if (l==r) {
			
			if (matrix[l][0]<=target && target<=matrix[l][n-1]) return l;
			return -1;
		}
		int m = (l+r)/2;
		int mValue = matrix[m][0];
		if (matrix[m][0] <= target && target <=matrix[m][n-1]) {
			return m;
		} else if (target<mValue) {
			return searchRow(l,m-1,matrix,target);
		} else {
			return searchRow(m+1,r,matrix,target);
		}
	}
	
	private boolean searchCol(int l, int r, int[] array, int target) {
		if (l>r) return false;
		if (l==r) return array[l] == target;
		int m = (l+r)/2;
		if (array[m] == target) {
			return true;
		} else if (target<array[m]) {
			return searchCol(l,m-1,array,target);
		} else {
			return searchCol(m+1,r,array, target);
		}
	}
}
