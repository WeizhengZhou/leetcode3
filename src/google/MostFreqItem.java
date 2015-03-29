
public class MostFreqItem {
	public void mostFreq(int[] A){
		if(A == null) return;
		int count = 1;
		int cand = A[0];
		for(int i=1;i<A.length;i++){
			if(A[i] == cand)
				count++;
			else 
				count--;
			if(count <= 0){
				cand = A[i];
				count = 1;
			}
		}
		System.out.println(cand);
	}
	public static void main(String[] args){
		int[] A = new int[]{1,4,2,3,4,5};
		MostFreqItem solu = new MostFreqItem();
		solu.mostFreq(A);
	}

}
