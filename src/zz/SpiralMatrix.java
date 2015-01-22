package zz;

import java.util.Arrays;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix s=new SpiralMatrix();
		System.out.println(Arrays.deepToString(s.generateMatrix(3)));
	}
	
	 public int[][] generateMatrix(int n) {
		 if(n<=0){
			 return new int[0][0];
		 }
		 int[][] res=new int[n][n];
		 int layers=n/2;
		 //int i=0;
		 int num=1;
		 for(int l=0;l<layers;l++){
			 for(int i=l;i<n-l-1;i++){
				 res[l][i]=num++;
			 }
			 for(int i=l;i<n-l-1;i++){
				 res[i][n-l-1]=num++;
			 }
			 for(int i=l;i<n-l-1;i++){
				 res[n-l-1][n-i-1]=num++;
			 }
			 for(int i=l;i<n-l-1;i++){
				 res[n-i-1][l]=num++;
			 }
		 }
		 if(n%2==1){
			 res[n/2][n/2]=n*n;
		 }
		 return res;
	 }

}
