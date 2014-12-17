package additional;

import java.util.Arrays;

public class KthSmall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmall k=new KthSmall();
		System.out.println(k.getKth(4, new int[]{3,0,1,6,7,4}));

	}
	
	public int getKth(int k, int[] A){
		if(A==null || A.length==0){
			return 0;
		}
		return quickSort(0,A.length-1,k,A);
	}

	public int quickSort(int l, int r, int k, int[] A){
		System.out.println("l="+l+",r="+r);
		if(l==r){
			return A[l];
		}
		int last=A[r];
		int i=partition(A,last,l,r);
		System.out.println("l="+l+",r="+r+",last="+last+",i="+i+",k="+k+",Array="+Arrays.toString(A));
		if(i==k){
			return A[i-1];
		}
		if(i<k){
			//return quickSort(i+l,r,k-i,A);
			return quickSort(i,r,k,A);
		}
		else{
			//System.out.println("i<");
			//return quickSort(l,l+i-2,k,A);
			return quickSort(l,i-2,k,A);
		}
	}
	
	public int partition(int[] A, int last,int l, int r){
		int i=l-1;
		int j=l;
		for(;j<r;j++){
			if(A[j]<last){
				i++;
				int temp=A[i];
				A[i]=A[j];
				A[j]=temp;
			}
		}
		i++;
		A[r]=A[i];
		A[i]=last;
		return i+1;
		//return i-l+1;
	}
}
