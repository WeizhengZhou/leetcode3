package additional;

import java.util.HashSet;
import java.util.Set;

public class PrimeLessN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeLessN p=new PrimeLessN();
		p.getPrimes(50);

	}
	
	public void getPrimes(int N){
		boolean[] A=new boolean[N+1];
		A[0]=true;
		A[1]=true;
		int i=2;
		while(i<Math.sqrt(N)){
			System.out.println("i="+i);
			for(int j=i*i;j<=N;j+=i){
				A[j]=true;
			}
			while(i+1<=N && A[i+1]){
				i++;
			}
			i++; 
		}
		for(int k=0;k<=N;k++){
			if(!A[k]){
				System.out.println(""+k);
			}
		}
	}

}
