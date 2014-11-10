package dp;

public class MaxProductSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxProductSubArray m=new MaxProductSubArray();
		System.out.println(m.maxProduct(new int[]{-2}));

	}
	
	public int maxProduct(int[] A){
		int maxP=1;
		int minP=1;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<A.length;i++){
			if(A[i]==0){
				maxP=1;
				minP=1;
				max=Math.max(max, 0);
			}
			else if(A[i]>0){
				maxP=maxP*A[i];
				minP=Math.min(1, minP*A[i]);
				max=Math.max(max, maxP);
			}
			else{
				if(minP==1){
					max=Math.max(max, A[i]);
				}
				else{
					max=Math.max(max, minP*A[i]);
				}
				int NewmaxP=Math.max(1, minP*A[i]);
				minP=maxP*A[i];
				maxP=NewmaxP;	
				
			}			
			//System.out.println("maxP="+maxP+",minP="+minP);
		}
		return max;
	}

}
