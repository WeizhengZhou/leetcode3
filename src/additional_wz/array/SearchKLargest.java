package array;
import java.util.*;

public class SearchKLargest{
    public int[] searchKLargest(int[] A, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,Collections.reverseOrder());
        for(int i=0;i<A.length;i++)
            pq.add(A[i]);
        int[] max = new int[k];
        for(int i=0;i<k;i++)
            max[i] = pq.remove();
        return max; 
    }
	public static void main(String[] args){
		int[] A = new int[]{2,1,4,5,3};
		int k = 2;
		int[] res = new SearchKLargest().searchKLargest(A,k);
		System.out.println(Arrays.toString(res));
	}
}
