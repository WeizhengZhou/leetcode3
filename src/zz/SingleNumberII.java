package zz;

public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int singleNumber(int[] A) {
		int carry=0;
		int ones=0;
		int twos=0;
		int mask=0;
		for(int i=0;i<A.length;i++){
			carry=ones&A[i];
			ones=ones^A[i];
			twos=twos|carry;
			mask=ones&twos;
			ones=ones^mask;
			twos=twos^mask;
		}
		return ones;
	}

}
