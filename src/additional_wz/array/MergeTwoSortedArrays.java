package array;
import java.util.Arrays;
public class MergeTwoSortedArrays{
	public int[] merge(int[] A, int[] B){
		if(A == null && B == null) return null;
		if(A == null || B == null) return (A != null)?A:B;
		int m = A.length;
		int n = B.length;
		int[] C = new int[m+n];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<m || j<n){
			if(j >= n){
				C[k++] = A[i++];
			}
			else if(i >= m){
				C[k++] = B[j++];
			}
			else if(A[i] < B[j]){
				C[k++] = A[i++];
			}
			else{
				C[k++] = B[j++];
			}
		}
		return C;
	}
	public static void main(String[] args){
		MergeTwoSortedArrays solu = new MergeTwoSortedArrays();
		int[] A = new int[]{1,3,5};
		int[] B = new int[]{2,4,6};
		int[] C = solu.merge(A,B);
		System.out.println(Arrays.toString(C));
	}

}
