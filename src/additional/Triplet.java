package additional;

import java.util.Arrays;

public class Triplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triplet t=new Triplet();
		System.out.println(t.numberTriplet(new int[]{1,2,3,5,7,9}, 8));

	}
	
	public int numberTriplet(int[] A, int target){
		Arrays.sort(A);
		int sum=0;
		for(int i=0; i<A.length; i++){
			int first=A[i];
			if(first<target){
				int l=i+1;
				int r=A.length-1;
				int t=target-first;
				while(l<r){
					if(A[l]+A[r]>t){
						r--;
					}
					else{
						sum+=r-l;
						l++;
					}
				}
			}
		}
		return sum;
	}

}
