package zz;

public class CanJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean canJump(int[] A) {
		if(A==null || A.length==0){
			return false;
		}
		int i=0;
		int dist=A[0];
		while(i<=dist){
			dist=Math.max(dist, i+A[i]);
			if(dist>=A.length-1){
				return true;
			}
			i++;
		}
		return i==A.length;
	}

}
