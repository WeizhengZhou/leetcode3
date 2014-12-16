package additional_wz;

import java.util.Arrays;

public class Fabonacci {
	public int[] fabonacci_dp(int n){
		if(n < 0) return null;
		if(n == 0) return new int[]{1};
		if(n == 1) return new int[]{1,1};
		int[] res = new int[n+1];
		res[0] = 1;
		res[1] = 1;
		for(int i=2;i<=n;i++){
			res[i] = res[i-1]+res[i-2];
		}
		return res;
	}
	public long fabonacci_matrix(int n){
		long[][][] table = new long[32][2][2];
		table[0][0][0] = 1;
		table[0][0][1] = 1;
		table[0][1][0] = 1;
		table[0][1][1] = 0;
		for(int k = 1;k<32;k++){
			table[k] = multiply(table[k-1], table[k-1]);	
		}
		long[][] matrix = new long[2][2];
		matrix[0][0] = 1;
		matrix[1][1] = 1;
		for(int i=0;i<32;i++){
			if(((n-1) & (1<<i)) != 0){
				matrix = multiply(matrix,table[i]);
			}
		}
		return matrix[0][0] + matrix[0][1];
	}
	private long[][] multiply(long[][] A, long[][] B){//only support 2by2 matrix		
		long[][] res = new long[2][2];
		res[0][0] = A[0][0]*B[0][0] + A[0][1]*B[1][0];
		res[0][1] = A[0][0]*B[0][1] + A[0][1]*B[1][1];
		res[1][0] = A[1][0]*B[0][0] + A[1][1]*B[1][0];
		res[1][1] = A[1][0]*B[0][1] + A[1][1]*B[1][1];
		return res;
	}
	public static void main(String[] args){
		Fabonacci solu = new Fabonacci();
		int n = 20;
		int[] res = solu.fabonacci_dp(n);
		System.out.println(Arrays.toString(res));
		System.out.println(solu.fabonacci_matrix(n));
		
	}
}
