package array;

public class MaximumDiffDivision{
	public int findDivision(int[] A){
		if(A == null || A.length < 2) return -1;
		int[] B = new int[A.length];//accumulate sum end at i
		int[] C = new int[A.length];//accumulate sum start at i
		int sum = 0;
		for(int i=0;i<A.length;i++){
			sum += A[i];
			B[i] = sum;
		}
		sum = 0;
		for(int i=A.length-1;i>=0;i--){
			sum += A[i];
			C[i] = sum;
		}

		int maxDiff = Integer.MIN_VALUE;
		int diff = 0;
		for(int i=1;i<A.length-1;i++){
			diff = C[i] - (B[i] - A[i]);//i goes to C
			maxDiff = Math.max(maxDiff,diff);
		}
		return maxDiff;	
	}
	public static void main(String[] args){
		MaximumDiffDivision solu = new MaximumDiffDivision();
		int[] A = new int[]{2, -1, -2, 1, -4, 2, 8};
		System.out.println("res_index =  " + solu.findDivision(A) + ", expected = 14 ");
	}
}
