package array;
import java.util.*;
public class MaximumEachKSubarray{
	public void maximumEachKSubarray(int[] A, int k){
		if(A == null || k > A.length) return;
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		for(int i=0;i<k;i++)
			set.add(A[i]);
		int[] res = new int[A.length - k + 1];
		res[0] = set.first();
		for(int i=k;i<A.length;i++){
			set.remove(A[i-k]);
			set.add(A[i]);
			res[i-k+1] = set.first(); 
		}
		System.out.println(Arrays.toString(res));
		
	}
	public void helper(int[] A, int k){
		Deque<Integer> dq = new LinkedList<>();
		for(int i=0;i<k;i++){
			while(!dq.isEmpty() && A[i] >= A[dq.peekFirst()])
				dq.pollFirst();
			dq.offerLast(i);	
			System.out.println(dq);
		}
		System.out.println(A[dq.peekFirst()]);
		for(int i=k;i<A.length;i++){
			while(!dq.isEmpty() && (i-dq.peekFirst()) >= k)
				dq.pollFirst();
			while(!dq.isEmpty() && A[i] >= A[dq.peekFirst()])
				dq.pollFirst();
			dq.offerLast(i);
			System.out.println(A[dq.peekFirst()]);
		}		
	}
    public static void main(String[] args){
		int[] A = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 3;
		System.out.println(Arrays.toString(A));
		MaximumEachKSubarray solu = new MaximumEachKSubarray();
//		solu.maximumEachKSubarray(A,k);
		solu.helper(A, k);

	}
}
