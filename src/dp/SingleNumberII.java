package dp;

public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumberII s=new SingleNumberII();
		int i=s.singleNumber(new int[]{-2,-2,-3,-2});
		System.out.println(i);
	}
    public int singleNumber(int[] A) {
        if(A==null ||A.length==0){
        	return 0;
        }
        int ones=0;
        int temp=0;
        int twos=0;
        //int s=1;
        int c=0;
        for(int i=0;i<A.length;i++){
        	if(A[i]<0){
        		c++;
        		//s=s*(-1);
        	}
        	int a=Math.abs(A[i]);
        	temp=ones&a;
        	//System.out.print("temp="+Integer.toBinaryString(temp));
        	ones=ones^a;
        	//System.out.print(",ones="+Integer.toBinaryString(ones));
        	twos=temp^twos;        	
        	//System.out.print(",twos="+Integer.toBinaryString(twos));
        	//System.out.println("");
        }
        if(c%3==0)
        {
        	return temp+ones;
        }
        else{
        	return -(temp+ones);
        }
    }
}
