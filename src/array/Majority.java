package array;
import java.util.*;
public class Majority{
	public int getMajority_vote(int[] A){//Moore's voting algorithm 
		if(A == null || A.length < 1) return -1;
		int maj_index = 0;
		int count = 1;
		//find the most frequent element
		for(int i=1;i<A.length;i++){
			if(A[i] == A[maj_index]) count++;
			else count--;
			if(count == 0){
				maj_index = i;
				count = 1;
			}
		}
		//check if it is the majority
		count = 0;
		for(int i=0;i<A.length;i++){
			if(A[i] == A[maj_index]) count++;
		}
		if(count > A.length/2) return A[maj_index];	
		else return -1;
	}
	public int getMajority(int[] A){
		if(A == null) return -1;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<A.length;i++){
			if(!map.containsKey(A[i]))
				map.put(A[i],1);
			else
				map.put(A[i],map.get(A[i])+1);
		}
		Set<Integer> keySet = map.keySet();
		for(Integer key:keySet){
			if(map.get(key) >= A.length/2)
				return key;
		}
		return -1;
	}
	public static void main(String[] args){
		Majority solu = new Majority();
		int[] A = new int[]{1,1,2};
		System.out.println("Array = " + Arrays.toString(A) + ", majority = " + solu.getMajority_vote(A));
		A = new int[]{1};
		System.out.println("Array = " + Arrays.toString(A)+ ", majority = " + solu.getMajority_vote(A));
		A = new int[]{1,1,2,2};
		System.out.println("Array = " + Arrays.toString(A)+ ", majority = " + solu.getMajority_vote(A));
	    A = new int[]{1,1,1};
		System.out.println("Array = " + Arrays.toString(A)+ ", majority = " + solu.getMajority_vote(A));
		
	}
}
