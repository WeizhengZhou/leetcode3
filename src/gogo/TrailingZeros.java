package gogo;

public class TrailingZeros {
    public int trailingZeroes(int n) {
        long d=5;
        int count=0;
        while(n/d>0){
        	count+=n/d;
        	d=d*5;
        }
        return count;
    }
}
