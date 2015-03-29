import java.util.Arrays;


public class WaveSort {
	public void waveSort(int[] A){
		if(A == null) return;
		for(int i=0;i<A.length-1;i++){
			if(i%2 == 0 && A[i] < A[i+1])
				swap(A,i,i+1);
			if(i%2 == 1 && A[i] > A[i+1])
				swap(A,i,i+1);
		}
		System.out.println(Arrays.toString(A));
	}
	private void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void main(String[] args){
		int[] A = new int[]{5,4,3,2,1};
		WaveSort solu = new WaveSort();
		solu.waveSort(A);	
	}
}
