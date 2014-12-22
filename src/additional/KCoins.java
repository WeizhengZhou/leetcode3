package additional;

public class KCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int ways(int[] A, int n, int k){
		int way=0;
		way=helper(0,A,n,k);
		return way;
	}
	
	public int helper(int index,int[] A, int n, int k){
		if(n==0){
			return 1;
		}
		if(index==A.length){
			return 0;
		}
		int w=0;
		//infinite times: k=n/A[index];
		/*one time: k not used
		 * w+=helper(index+1,A,n,k);
		 * w+=helper(index+1,A,n-A[index],k);
		 */
		for(int i=0; i<=k; i++){
			w+=helper(index+1,A,n-i*A[index],k);
		}
		return w;
	}

}
