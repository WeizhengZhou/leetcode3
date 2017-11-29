package gogo;

public class Pow {
	public double myPow(double x, int n) {
        if (n==0) return 1;
        if (n==1) return x;
        int power = n>0 ? n:-n;
        double re = helper(x, power);
        return n>0 ? re : 1/re;
    }
	private double helper(double x, int n) {
		if (n==0) return 1;
        if (n==1) return x;
        if (n%2==0) {
        	return helper(x*x,n/2);
        } else {
        	return x*helper(x*x,n/2);
        }
	}
}
