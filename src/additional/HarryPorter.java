package additional;

public class HarryPorter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HarryPorter h=new HarryPorter();
		System.out.println(h.minEnergy(new int[][]{{3,-100,1},{-10,0,-9}}));

	}
	
	public int minEnergy(int[][] A){
		int n=A.length;
		int m=A[0].length;
		A[n-1][m-1]=Math.min(0, A[n-1][m-1]);
		for(int i=n-2; i>=0; i--){
			A[i][m-1]=Math.min(0, A[i][m-1]+A[i+1][m-1]);
		}
		for(int i=m-2; i>=0; i--){
			A[n-1][i]=Math.min(0, A[n-1][i]+A[n-1][i+1]);
		}
		for(int i=n-2; i>=0; i--){
			for(int j=m-2; j>=0; j--){
				int right=Math.min(A[i][j]+A[i][j+1], 0); 
				int down=Math.min(A[i][j]+A[i+1][j], 0); 
				A[i][j]=Math.max(right, down);
			}			
		}
		return A[0][0]>0?0:-A[0][0];
	}

}
