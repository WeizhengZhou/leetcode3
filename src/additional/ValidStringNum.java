package additional;

public class ValidStringNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getNumber(int N){
		int same=3;
		int diff=0;
		for(int i=2; i<=N; i++){
			int temp=same;
			same=diff+same;
			diff=temp*2+diff;
		}
		return same+diff;
	}
}
