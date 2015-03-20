package xx;

public class SetMatrixZero {
	public void setZeroes(int[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0){return;}
		boolean setFirstRow=false;
		boolean setFirstCol=false;
		for(int i=0;i<matrix.length;i++){
			if(matrix[i][0]==0){ setFirstCol=true; break;}
		}
		for(int j=0;j<matrix[0].length;j++){
			if(matrix[0][j]==0){setFirstRow=true;break;}
		}
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		for(int i=1;i<matrix.length;i++){
			if(matrix[i][0]==0){ 
				for(int j=1;j<matrix[0].length;j++){ matrix[i][j]=0;}
			}
		}
		for(int j=1;j<matrix[0].length;j++){
			if(matrix[0][j]==0){ 
				for(int i=1;i<matrix.length;i++){ matrix[i][j]=0;}
			}
		}
		if(setFirstRow){
			for(int j=0;j<matrix[0].length;j++){ matrix[0][j]=0;}
		}
		if(setFirstCol){
			for(int i=0;i<matrix.length;i++){ matrix[i][0]=0;}
		}
	}
}
