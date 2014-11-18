package dp;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean canJump(int[] A) {
        int max=0;
        int i=0;
        while(i<=max&&i<A.length){
        	int j=i+A[i];
        	max=Math.max(max, j);
        	i++;
        }
        return i>=A.length?true:false;
    }

}
