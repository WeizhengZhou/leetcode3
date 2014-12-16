package array;

import java.util.*;
public class RearrangeArraySwapWithZero {
	public void rearrange(int[] A, int[] T){
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<T.length;i++)
			map.put(T[i],i);
		
		int zeroIndex = 0;
		for(int i=0;i<A.length;i++)
			if(A[i] == 0) 
				zeroIndex = i;
		System.out.println(zeroIndex);
		for(int i=0;i<A.length;i++){
			System.out.println("i = " + i + ", A[i] = " + A[i] + ", targetIndex = " + map.get(A[i]));
			if(A[i] == 0 || map.get(A[i]) == i)
				continue;
			else{
				int targetIndex = map.get(A[i]);
				if(targetIndex == zeroIndex){
					swap(A,i,targetIndex);
					zeroIndex = i;
				}
				else{
					swap(A,i,zeroIndex);
					swap(A,zeroIndex,targetIndex);
					swap(A,i,zeroIndex);
					System.out.println(Arrays.toString(A));
					i--;
				}
			}
		}
		
	}
	private void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void main(String[] args){
		int[] A = new int[]{1,0,2,3};
		int[] T = new int[]{0,2,3,1};
		RearrangeArraySwapWithZero solu = new RearrangeArraySwapWithZero();
		solu.rearrange(A,T);
		System.out.println(Arrays.toString(A));
		
	}
}
