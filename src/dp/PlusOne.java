package dp;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] plusOne(int[] digits){
		if(digits==null||digits.length==0){
			return new int[]{1};
		}
		int[] res=new int[digits.length+1];
		int carry=1;
		for(int i=digits.length-1;i>=0;i--){
			res[i+1]=(digits[i]+carry)%10;
			carry=(digits[i]+carry)/10;
		}
		res[0]=carry;
		if(res[0]==0){
			return Arrays.copyOfRange(res, 1, res.length);
		}
		else{
			return res;
		}
	}

}
