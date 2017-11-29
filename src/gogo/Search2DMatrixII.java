package gogo;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        return helper(0,matrix.length-1,matrix,target);
    }
    private boolean helper(int l, int r, int[][] matrix, int target) {
    	if (l>r) return false;
    	if (l==r) return bs(0,matrix[0].length-1,matrix[l],target);
    	int m=(l+r)/2;
    	int cols=matrix[0].length;
    	if (target<matrix[m][0]) {
    		return helper(l,m-1,matrix,target);
    	} else if (target>matrix[m][cols-1]) {
    		return helper(m+1,r,matrix,target);
    	} else if (bs(0,cols-1,matrix[m],target)) {
    		return true;
    	} else {
    		return helper(l,m-1,matrix,target) || helper(m+1,r,matrix,target);
    	}
    }
    
    private boolean bs(int l, int r, int[] A, int target) {
    	if (l>r) return false;
    	if (l==r) return A[l]==target;
    	int m=(l+r)/2;
    	if (A[m]==target) {
    		return true;
    	} else if (target<A[m]) {
    		return bs(l,m-1,A,target);
    	} else {
    		return bs(m+1,r,A,target);
    	}
    }
}
