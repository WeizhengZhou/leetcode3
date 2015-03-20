package xx;

public class JumpGameII {
	 public int jump(int[] A) {
		 if(A==null || A.length<=1){
		 	return 0;
		 }
		 int steps=1;
		 int indexRange=0;
		 int nextRange=0;
		 int i=0;
		 while(i<=indexRange){
		 	int curRange=i+A[i];
		 	nextRange=Math.max(nextRange,curRange);
		 if(curRange>=A.length-1){return steps;}
		 	if(i==indexRange){
		 	indexRange=nextRange;
		 	steps++;
		 }
		 i++;
		 }
		 return steps;
		     }
}
