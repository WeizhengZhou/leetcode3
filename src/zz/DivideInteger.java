//zz reviewed

package zz;

public class DivideInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//zz, 1. consider the iterative solution
	//    2. question: will this recursive solution suffer stackoverflow exception?
	//              what is the worest case running time?
	//    3. in each recursive call, the sign of the result is calculated, however, this step is only need once
	
	 public int divide(int dividend, int divisor) {
		 //zz, if divisor = 0, throw exception
		 if (dividend==0 || divisor==0){
			 return 0;
		 }
		 if(dividend==Integer.MIN_VALUE && divisor==-1){//zz, if divisor is Integer.min_value, will you give correct answer
			 return Integer.MAX_VALUE;
		 }
		 boolean isPos=dividend>0&&divisor>0||dividend<0&&divisor<0?true:false;//zz, consider a bit-level sign expression
		 int absDividend=dividend>0?-dividend:dividend;//zz, since it is negative, it should not be called "abs"
		 int absDivisor=divisor>0?-divisor:divisor;
		 if(absDividend>absDivisor){//zz, write comments
			 return 0;
		 }
		 int x=absDividend;
		 int y=absDivisor;
		 int res=1;
		 while(x-y<=y){
			 y=y+y;
			 res+=res;
		 }
		 res=res+divide(x-y,absDivisor);
		 return isPos?res:-res;
	 }
}
