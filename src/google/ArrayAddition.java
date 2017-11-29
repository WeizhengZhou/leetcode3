import java.util.Arrays;


public class ArrayAddition {
	public int[] add(int[] A, int[] B){
		if(A == null) return B;
		if(B == null) return A;
		int len = Math.max(A.length, B.length)+1;
		int[] res = new int[len];
		int i = A.length-1;
		int j = B.length-1;
		int k = res.length-1;
		int carry = 0;
		while(i>=0 || j>=0){
			if(i >= 0){
				carry += A[i--];
			}
			if(j >= 0){
				carry += B[j--];
			}
			res[k--] = carry%10;
			carry /= 10;	
		}
		if(carry == 0){
			return Arrays.copyOfRange(res, 1, res.length);
		}
		else{
			res[0] = 1;
			return res;
		}
	}
	public static void main(String[] args){
		int[] A = new int[]{1,2,3};
		int[] B = new int[]{-1,-1,-1};
		int[] res = new ArrayAddition().add(A, B);
		System.out.println(Arrays.toString(res));
	}
}
