package array;

import java.util.*;
public class Island {
	public double probability(int N, int x, int y, int k){
		double[][][] table = new double[k+1][N+2][N+2];
		for(int i=0;i<=N+1;i++){
			for(int j=0;j<=N+1;j++){
				if(i == 0 || i==N+1 || j ==0 || j==N+1)
					table[0][i][j] = 0;
				else
					table[0][i][j] = 1;
			}
		}
		this.print(table[0]);
		for(int s=1;s<=k;s++){
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					table[s][i][j] = 0.25 * (table[s-1][i-1][j] + table[s-1][i+1][j] + 
											 table[s-1][i][j-1] + table[s-1][i][j+1]);
				} 
			}
			this.print(table[s]);
		}
		return table[k][x+1][y+1];
	}
	public static void main(String[] args){
		Island solu = new Island();
		System.out.println(solu.probability(3, 1, 1, 10));
	}
	private void print(double[][] A){
		for(double[] row : A){
			for(double d:row){
				System.out.print(d + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
