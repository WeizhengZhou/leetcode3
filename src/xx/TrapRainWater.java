package xx;

public class TrapRainWater {
	public int trap(int[] A) {
		if(A==null || A.length<=2){return 0;}
		int[] leftWall=new int[A.length];//highest “wall” in the left, ie  max(A[0...i-1]) 
		int[] rightWall=new int[A.length];
		//build left
		leftWall[0]=0;
		int left=0;
		for(int i=0;i<A.length;i++){
			leftWall[i]=left;
			left=Math.max(left,A[i]);
		}
		int total=0;
		rightWall[A.length-1]=0;
		int right=0;
		for(int i=A.length-1;i>=0;i--){
			rightWall[i]=right;
			right=Math.max(right,A[i]);
			int curWater=Math.min(leftWall[i],rightWall[i])-A[i];
			total+=curWater>0?curWater:0;
		}
		return total;

	}
}
