package gogo;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n<=0) return false;
        while(n>0) {
        	if (n%3>0) return false;
        	n=n/3;
        }
        return true;
    }
}
