package xx;

public class FractorialTrailingZero {
	 public int trailingZeroes(int n) {
	        int count=0;
	        int divisor=1;
	        while(n/divisor/5>0){
	            count+=n/divisor/5;
	            divisor=divisor*5;
	        }
	        return count;
	    }
}
