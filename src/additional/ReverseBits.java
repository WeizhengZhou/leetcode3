package additional;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int reverse(int n){
		int l=n;
		int size=0;
		while(l!=0){
			size++;
			l=l>>1;
		}
		int m=size/2;
		for(int i=0;i<m; i++){
			int j=size-i-1;
			int ith=n>>i &1;
			int jth=n>>j&1;
			if(ith!=jth){
				n=n^1<<j;
				n=n^1<<i;
			}
		}
		return n;
	}
}
