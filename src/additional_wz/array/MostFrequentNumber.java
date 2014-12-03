package array;

public class MostFrequentNumber {
	public int mostFrequent(int[] A){
		if(A == null) return -1;
		int index = 0;
		int count = 1;
		for(int i=1;i<A.length;i++){
			if(A[i] == A[index]) count++;
			else count--;
			if(count ==0){
				index = i;
				count = 1;
			}
		}
		return A[index];
	}
	public static void main(String[] args){
		int[] A = new int[]{1,2,3,2,4};
		MostFrequentNumber solu = new MostFrequentNumber();
		System.out.println(solu.mostFrequent(A));
	}
}
