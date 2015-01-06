package zz;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int singleNumber(int[] A) {
		int xor=0;
		for(int i=0;i<A.length;i++){
			xor^=A[i];
		}
		return xor;
	}

}
