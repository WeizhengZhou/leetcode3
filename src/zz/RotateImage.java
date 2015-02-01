//zz reviewed
package zz;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void rotate(int[][] matrix) {
		if(matrix==null || matrix.length==0){
			return;
		}
		int n=matrix.length;
		int layers=n/2;
		for(int l=0;l<layers;l++){
			for(int i=l;i<n-1-l;i++){
				int temp=matrix[l][i];
				matrix[l][i]=matrix[n-1-i][l];
				matrix[n-1-i][l]=matrix[n-1-l][n-1-i];
				matrix[n-1-l][n-1-i]=matrix[i][n-1-l];
				matrix[i][n-1-l]=temp;
			}
		}
	}

}
