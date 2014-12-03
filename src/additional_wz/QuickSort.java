import java.util.Arrays;


public class QuickSort {
	public int[] quickSort(int[] A){
		if(A == null || A.length < 1) return A;
		partition(A,0,A.length-1);	
		return A;
	}
	public void partition(int[] A, int start, int end){
		if(start >= end) return;
		int p = end;
		int l = start;
		int r = end;		
		while(l<r){
			if(A[l] <= A[p])
				l++;
			else
				swap(A,--r,l);
		}
		swap(A,l,p);
		
		System.out.println("start = " + start + ", end = " + end + ", " + Arrays.toString(A));
		partition(A,start,l-1);
		partition(A,l+1,end);
	}
	private void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void main(String[] args){
		int[] A = new int[]{1,5,8,3,4};
		QuickSort solu = new QuickSort();
//		solu.partition(A,0,3);
		solu.quickSort(A);
		
	}
}
