package zz;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] plusOne(int[] digits){
		if(digits==null || digits.length==0){
			return digits;
		}
		int[] sum=new int[digits.length+1];
		int d=digits.length;
		int carry=1;
		for(int i=digits.length-1;i>=0;i--){
			carry+=digits[i];
			sum[d]=carry%10;
			carry=carry/10;
			d--;
		}
		if(carry!=0){
			sum[0]=1;
			return sum;
		}
		else{
			return Arrays.copyOfRange(sum, 1, sum.length);
		}
	}
	

}
