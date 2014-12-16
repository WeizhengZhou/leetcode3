package array;

import java.util.*;
public class FirstMissingPostiveInteger{
	public int firstMissingPostiveInteger(int[] A){
		if(A == null || A.length == 0) return 1;
		int i = 0;//outer loop index
		int j = 0;//inner loop index
        int magic = 0;//magic number such that A[magic-1] = magic
		int temp = 0;//swap temp
		while(i<A.length){//loop each element in A
			j = i;//inner loop index
			magic = A[i];//store magic number
			while(magic >= 1 && magic <= A.length && A[magic-1] != magic){//move magic number to A[magic], until magic out of range, or A[magic-1] = magic
				temp = A[magic-1];//store next magic number
				A[magic-1] = magic;//move magic number to right position
				magic = temp;//set next magic number
			}
			i++;//outer loop move forward
		}
		System.out.println(Arrays.toString(A));
		for(i=0;i<A.length;i++)//all elements in A, with value between 1 to A.length, should be in the magic position, 
								//the first missing integer can be found
			if(A[i] != i+1)
				return i+1;
		return A.length+1;
	}
	public static void main(String[] args){
		FirstMissingPostiveInteger solu = new FirstMissingPostiveInteger();
		int[] A = new int[]{-1,-2,1,3,5,2};
		System.out.println(solu.firstMissingPostiveInteger(A) + ", expected = 4");
	}
}
