package additional;

public class SwapBits {
	
	public int swapBits(int i, int j, int n){
		int ith=n>>i&1;
		int jth=n>>j&1;
		if(ith!=jth){
			n=n^1<<j;
			n=n^1<<i;
		}
		return n;
	}

}
