package dp;

public class TrapRain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int trap(int[] A) {
        int len=A.length;
        int[] left=new int[len];
        int[] right=new int[len];
        int LMax=0;
        for (int i=0;i<len;i++){
        	left[i]=LMax;
        	LMax=Math.max(LMax, A[i]);
        }
        int rMax=0;
        for (int i=len-1;i>=0;i--){
        	right[i]=rMax;
        	rMax=Math.max(rMax, A[i]);
        }
        int rain=0;
        for (int i=0;i<len;i++){
        	int height=Math.min(left[i], right[i])-A[i];
        	if (height>0){
        		rain+=height;
        	}
        }
        return rain;
    }

}
