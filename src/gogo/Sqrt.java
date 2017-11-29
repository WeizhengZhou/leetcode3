package gogo;

public class Sqrt {
	public int mySqrt(int x) {
        if (x<=0) return 0;
        return bs(0,x,x);
    }
	private int bs(int l, int r, int x) {
		if (l==r) return l;
		if (l+1 ==r) {
			if (r <= x/r) return r;
			return l;
		}
		int m = (l+r)/2;
		if (m<=x/m && (m+1)>x/(m+1)) {
			return m;
		} else if (m*m>x) {
			return bs(l,m-1,x);
		} else{
			return bs(m+1,r,x);
		}	
	}
}
