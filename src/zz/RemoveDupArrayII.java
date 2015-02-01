//zz reviewed

package zz;

public class RemoveDupArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeDuplicates(int[] A){
		if(A==null || A.length==0){
			return 0;
		}
		int len=0;//zz lastIndex
		int count=0;//zz duplicateCount
		for(int i=0;i<A.length;i++){
			if(i>0 && A[i]!=A[i-1]){
				count=1;
				A[len]=A[i];//A[len++] = A[i]
				len++;
			}
			else{//zz else if(count <2)
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
