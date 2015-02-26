package xx;

public class DivideInteger {
	public int divide(int dividend, int divisor) {
		 if(divisor==0)return Integer.MAX_VALUE;
		 if(dividend==0)return 0;
		 boolean isPos=divisor>0&&dividend>0||divisor<0&&dividend<0;
		 long div=(long)dividend;
		 long dividendAbs=Math.abs(div);
		 long divisorLong=(long)divisor;
		 long divisorAbs=Math.abs(divisorLong);
		 long res= helper(dividendAbs,divisorAbs);
		 if(isPos&&res>Integer.MAX_VALUE || !isPos&&res<Integer.MIN_VALUE){return Integer.MAX_VALUE;}
		 return isPos?(int)res:-(int)res;
	 }
	 private long helper(long dividend,long divisor){
	     if(divisor>dividend)return 0;
	     long res=1;
	     long div=divisor;
	     dividend-=div;
	     while(dividend-div>0){
	         res+=res;
	         dividend-=div;
	         div+=div;
	     }
	     return res+helper(dividend,divisor);
	 }
}
