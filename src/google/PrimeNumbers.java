import java.util.Arrays;


public class PrimeNumbers {
	public static void main(String[] args){
		int n = 100;
		boolean[] prime = new boolean[n+1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		prime[2] = false;
		for(int i=3;i<=n/2;i++){
			if(prime[i] == true){
				for(int j=2;i*j<=n;j++){
					prime[i*j] = false;
				}
			}
		}
		for(int i=2;i<=n;i++){
			if(prime[i] == true)
				System.out.println(i);
		}
	}

}
