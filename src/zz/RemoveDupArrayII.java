package zz;

public class RemoveDupArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(int[] A){
		if(A==null || A.length==0){
			return 0;
		}
		int len=0;
		int count=0;		
		for(int i=0;i<A.length;i++){
			if(i>0 && A[i]!=A[i-1]){
				count=1;
				A[len]=A[i];
				len++;
			}
			else{
				if(count<2){
					count++;
					A[len]=A[i];
					len++;
				}
			}
		}
		return len;
	}
	

}
