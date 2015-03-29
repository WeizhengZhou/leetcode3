
import java.util.*;
public class ProductExceptItself {
	public static void main(String[] args){
		int[] A = new int[]{1,2,3,4};
		int[] leftProd = new int[A.length];
		int[] rightProd = new int[A.length];
		leftProd[0] = 1;
		for(int i=1;i<A.length;i++)
			leftProd[i] = A[i-1] * leftProd[i-1];
		rightProd[A.length-1] = 1;
		for(int i=A.length-2;i>=0;i--)
			rightProd[i] = A[i+1] * rightProd[i+1];
		int[] res = new int[A.length];
		for(int i=0;i<A.length;i++){
			res[i] = leftProd[i] * rightProd[i];
		}
		System.out.println(Arrays.toString(res));
	}

}
