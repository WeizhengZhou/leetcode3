package zz;

public class FirstMissingPostive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int firstMissingPositive(int[] A) {
		if(A==null || A.length==0){
			return 1;
		}
		int i=0;
		while(i<A.length){
			int cur=A[i];
			if(cur>0 && cur<=A.length && A[i]!=i+1 && A[A[i]-1]!=A[i]){
				swap(i,A[i]-1,A);
			}
			else{
				i++;
			}
		}
		for(int j=0;j<A.length;j++){
			if(j+1!=A[j]){
				return j+1;
			}
		}
		return A.length+1;
	}

	public void swap(int x, int y, int[] A){
		int temp=A[x];
		A[x]=A[y];
		A[y]=temp;
	}
}
