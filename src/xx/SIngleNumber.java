package xx;

public class SIngleNumber {
	public int singleNumber(int[] A) {
        int xor=0;
        for(int i=0;i<A.length;i++){
            xor^=A[i];
        }
        return xor;
    }
}
