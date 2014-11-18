package dp;

public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int jump(int[] A) {
        int max=0;
        int i=0;
        int step=0;
        int next=0;
        while(i<=max && i<A.length){
        	if(max>=A.length-1){
        		return step;
        	}
        	for(int k=i;k<=max;k++){
        		int j=k+A[k];
        		next=Math.max(next, j);
        		
        	}
        	i=max+1;
        	step++;
        	max=next;
        	next=0;
        }
        return step;
    }
}
