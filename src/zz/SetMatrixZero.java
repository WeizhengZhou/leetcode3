package zz;

import java.util.Arrays;

public class SetMatrixZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub]
		SetMatrixZero s=new SetMatrixZero();
		s.setZeroes(new int[][]{{1},{0}});

	}
	
	public void setZeroes(int[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0){
			return;
		}
		boolean firstRow=false;
		boolean firstCol=false;
		for(int i=0;i<matrix[0].length;i++){
			if(matrix[0][i]==0){
				firstRow=true;
			}
		}
		for(int i=0;i<matrix.length;i++){
			if(matrix[i][0]==0){
				firstCol=true;
			}
		}
		for(int i=1;i<matrix[0].length;i++){
			for(int j=1;j<matrix.length;j++){
				if(matrix[j][i]==0){
					matrix[0][i]=0;
					matrix[j][0]=0;
					//break;
				}
			}
		}
		//System.out.println(Arrays.deepToString(matrix));
		for(int i=1;i<matrix[0].length;i++){
			if(matrix[0][i]==0){
				for(int j=1;j<matrix.length;j++){
					matrix[j][i]=0;
				}
			}
		}
		for(int j=1;j<matrix.length;j++){
			if(matrix[j][0]==0){
				for(int i=1;i<matrix[0].length;i++){
					matrix[j][i]=0;
				}
			}
		}
		if(firstCol){
			for(int j=0;j<matrix.length;j++){
				matrix[j][0]=0;
			}
		}
		if(firstRow){
			for(int j=0;j<matrix[0].length;j++){
				matrix[0][j]=0;
			}
		}

		//System.out.println(Arrays.deepToString(matrix));
	}

}
