
public class Cavity {
	public void findCavities(int[][] A){
		int m = A.length;
		int n = A[0].length;
		
		boolean[][] visited = new boolean[m][n];
		for(int i=1;i<m-1;i++){
			for(int j=1;j<n-1;j++){
				if(visited[i][j] == false){
					if(A[i][j] < A[i-1][j] && A[i][j] < A[i+1][j] && A[i][j] < A[i][j-1] && A[i][j] < A[i][j+1]){
						visited[i][j] = true;
						System.out.println("i = " + i + ", j = " + j + " is a cavity");
					}		
					if(A[i][j] <= A[i-1][j]) {
						visited[i-1][j] = true;
					}
					if(A[i][j] <= A[i+1][j]) {
						visited[i+1][j] = true;
					}
					if(A[i][j] <= A[i][j-1]) {
						visited[i][j-1] = true;
					}
					if(A[i][j] <= A[i][j+1]) {
						visited[i][j+1] = true;
					}
				}
			}
		}
	}
	public static void main(String[] args){
		int[][] A = new int[][]{
				{2,2,2,2,1},
				{2,1,2,1,2},
				{2,2,2,1,2},
				{2,1,2,1,2},
				{2,2,2,2,2}};
		Cavity solu = new Cavity();
		solu.findCavities(A);
		
	}
}
