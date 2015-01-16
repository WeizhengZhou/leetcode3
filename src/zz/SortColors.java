package zz;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public void sortColors(int[] A) {
		 if(A==null || A.length==0){
			 return;
		 }
		 int zeros=-1;
		 int twos=A.length;
		 int i=0;
		 while(i<twos){
			 if(A[i]==0){
				 zeros++;
				 swap(zeros,i,A);
				 i++;
			 }
			 else if(A[i]==2){
				 twos--;
				 swap(twos,i,A);
			 }
			 else{
				 i++;
			 }
		 }
	 }
	 
	 public void swap(int i, int j,int[] A){
		 int temp=A[i];
		 A[i]=A[j];
		 A[j]=temp;
	 }

}
