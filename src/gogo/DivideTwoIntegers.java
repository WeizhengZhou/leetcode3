package gogo;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
       if (divisor == 0) return Integer.MAX_VALUE;
       if (dividend == 0) return 0;
       if(dividend==Integer.MIN_VALUE && divisor==-1){//zz, if divisor is Integer.min_value, will you give correct answer
			 return Integer.MAX_VALUE;
		 }
       boolean isPo = dividend>0 && divisor>0 || dividend < 0 && divisor < 0 ? true : false;
       int absdividend = dividend > 0 ? -dividend: +dividend;
       int absdivisor = divisor > 0 ? -divisor: +divisor;
       int re = divideHelper(absdividend, absdivisor);
       return isPo ? re:-re;
    }
	
	public int divideHelper(int dividend, int divisor) {
		if (dividend > divisor) return 0;
		int sum = divisor;
		int res = 1;
		while (dividend - sum <= sum) {
			sum += sum;
			res += res;
		}
		return res+divideHelper(dividend-sum, divisor);
	}
}
