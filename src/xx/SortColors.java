package xx;

public class SortColors {
	public void sortColors(int[] A) {
		if(A==null || A.length<=1){return;}
		int zeroIndex=-1;
		int twoIndex=A.length;
		int i=0;
		while(i<twoIndex){
			if(A[i]==0){
				swap(++zeroIndex,i++,A);
			}
			else if(A[i]==1){
				i++;
			}
			else{
				swap(--twoIndex,i,A);
			}
		}
	}

	private void swap(int i,int j, int[] A){
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
}
