package dp;

public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.toBinaryString(-1));
		SingleNumberII s=new SingleNumberII();
		int i=s.singleNumber(new int[]{-4,-4,-1,-4});
		System.out.println(i);
	}
    public int singleNumber(int[] A) {
        if(A==null ||A.length==0){
        	return 0;
        }
        int ones=0;
        int carry=0;
        int mask=0;
        int twos=0;
        //int s=1;
        //int c=0;
        for(int i=0;i<A.length;i++){
        	int a=A[i];
        	carry=ones&a;
        	//mask=carry^twos;
        	ones=(a^ones);
        	twos=twos^carry;
        	mask = ones&twos;
        	ones = ones^mask;
        	twos = twos^mask;
        	//System.out.print("temp="+Integer.toBinaryString(temp));
        	//ones=ones^a;
        	//System.out.print(",ones="+Integer.toBinaryString(ones));
        	//twos=carry^twos;        	
        	//System.out.print(",twos="+Integer.toBinaryString(twos));
        	//System.out.println("");
        }
        return ones;
    }
}
