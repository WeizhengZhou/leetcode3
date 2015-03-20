package xx;

public class PlushOne {
	public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0){
			return digits;
		}
		int[] sum=new int[digits.length+1];
		int carry=1;
		for(int i=digits.length-1;i>=0;i--){
		    carry+=digits[i];
		    sum[i+1]=carry%10;
		    carry/=10;
		}
		if(carry!=0){
		    sum[0]=carry;
		    return sum;
		}
		else{
		    return Arrays.copyOfRange(sum,1,sum.length);
		}
    }
}
