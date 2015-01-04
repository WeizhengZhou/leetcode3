package zz;

public class MaxProductA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxProductA m=new MaxProductA();
		System.out.println(m.maxProduct(new int[]{2,3,-2,4}));

	}
    public int maxProduct(int[] A) {
    	if(A==null){
    		return 0;
    	}
    	if(A.length==1){
    		return A[0];
    	}
        int max=1;
        int min=1;
        int realMax=A[0];
        int T=Integer.MIN_VALUE;
        int pre=1;
        for(int i=0;i<A.length;i++){
        	if(A[i]>0){
        		realMax=max*A[i];
        		max=Math.max(1,max*A[i]);
        		min=Math.min(1,min*A[i]);
        	}
        	else if(A[i]<0){
        		pre=max;
        		realMax=min*A[i];
        		max=Math.max(1,min*A[i]);
        		min=Math.min(1,pre*A[i]);
        	}
        	else{
        		realMax=0;
        		max=1;
        		min=1;
        	}
        	//System.out.println(max+" "+min);
        	T=Math.max(realMax, T);
        }
        return T;
    }
}
