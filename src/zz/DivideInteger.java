package zz;

public class DivideInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int divide(int dividend, int divisor) {
		 if (dividend==0 || divisor==0){
			 return 0;
		 }
		 if(dividend==Integer.MIN_VALUE && divisor==-1){
			 return Integer.MAX_VALUE;
		 }
		 boolean isPos=dividend>0&&divisor>0||dividend<0&&divisor<0?true:false;
		 int absDividend=dividend>0?-dividend:dividend;
		 int absDivisor=divisor>0?-divisor:divisor;
		 if(absDividend>absDivisor){
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
