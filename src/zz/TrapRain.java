//zz reviewed
package zz;

public class TrapRain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int trap(int[] A) {
		 if(A==null || A.length<=2){
			 return 0;
		 }
		 int[] leftHigh=new int[A.length];
		 int[] rightHigh=new int[A.length];
		 int left =0;
		 for(int i=0;i<A.length;i++){
			 leftHigh[i]=left;
			 left=Math.max(left, A[i]);
		 }
		 int right=0;
		 int water=0;
		 for(int i=A.length-1;i>=0;i--){
			 rightHigh[i]=right;
			 int cur=Math.min(rightHigh[i], leftHigh[i])-A[i];
			 water+=cur>0?cur:0;
			 right=Math.max(right, A[i]);
		 }
		 return water;		 
	 }
}
