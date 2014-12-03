package additional;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A=new int[]{1,2,3,4};
		Shuffle s=new Shuffle();
		s.shuffle(A);
		System.out.println(Arrays.toString(A));

	}
	public void shuffle(int[] A){
		if(A==null){
			return;
		}
		Random rd=new Random();
		for(int i=A.length-1; i>=0; i--){
			int j=rd.nextInt(i+1);
			int temp=A[j];
			A[j]=A[i];
			A[i]=temp;
		}
	}
}
