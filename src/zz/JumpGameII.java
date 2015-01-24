package zz;

public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int jump(int[] A) {
		 if(A==null || A.length <=1){
			 return 0;
		 }
		 int step=0;
		 int i=0;
		 int dist=A[0];
		 int next=0;
		 while(i<=dist){
			 next=Math.max(next, i+A[i]);
			 i++;
			 if(i>dist){
				 dist=next;
				 step++;
				 if(dist>=A.length-1){
					 return step;
				 }
			 }
		 }
		 return step;
	 }
}
