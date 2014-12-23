package additional;

import java.util.Arrays;

public class Product {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p=new Product();
		System.out.println(Arrays.toString(p.getProduct(new int[]{1,2,3,4})));

	}

	public int[] getProduct(int[] A){
		int[] l=new int[A.length];
		int[] r=new int[A.length];
		l[0]=1;
		r[A.length-1]=1;
		for(int i=1;i<A.length;i++){
			l[i]=l[i-1]*A[i-1];
		}
		for(int i=A.length-2;i>=0;i--){
			r[i]=r[i+1]*A[i+1];
		}
		int[] res=new int[A.length];
		for(int i=0;i<A.length;i++){
			res[i]=l[i]*r[i];
		}
		return res;
	}
}
