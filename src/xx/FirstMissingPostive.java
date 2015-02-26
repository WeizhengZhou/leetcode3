package xx;

public class FirstMissingPostive {
	public int firstMissingPositive(int[] A) {
		if(A==null || A.length==0){
			return 1;
		}
		int i=0;
		while(i<A.length){
			int cur=A[i];
			//[2,1,0]
			//cur=2, cur!=1 && 1!=2
			if(cur>0 && cur<A.length && cur!=i+1 && A[cur-1]!=cur){
				A[i]=A[cur-1];	
				A[cur-1]=cur;	
			}
			else{
				i++;
			}
		}
		for(int j=0;j<A.length;j++){
			if(A[j]!=j+1){return j+1;}
		}
		return A.length+1;
	}
}
