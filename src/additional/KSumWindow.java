package additional;

import java.util.Arrays;

public class KSumWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSumWindow k=new KSumWindow();
		System.out.println(Arrays.toString(k.KSum(new int[]{1,2,3,4,5}, 2)));

	}
	
	public int[] KSum(int[] A, int k){
		int i=0;
		int j=0;
		int sum=0;
		for(;j<k;j++){
			sum+=A[j];
		}
		int[] res=new int[A.length-k+1];
		res[0]=sum;
		for(;i<A.length-k;i++){
			sum-=A[i];
			sum+=A[j];
			j++;
			res[i+1]=sum;
		}
		return res;
	}

}
