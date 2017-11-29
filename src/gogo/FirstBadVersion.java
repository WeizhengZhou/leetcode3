package gogo;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n<=0) return 0;
		int l=1;
		int r=n;
		while(l<=r) {
			int m=l+(r-l)/2;
			if (isBadVersion(m) && !isBadVersion(m-1)) {
				return m;
			} else if (isBadVersion(m-1)) {
				r=m-1;
			} else {
				l=m+1;
			}
		}
		return 0;
    }
    
    private int helper(int l, int r, int n) {
    	if (l==r) {
    		return isBadVersion(l) ? l : 0;
    	}
    	if (l+1==r) {
    		return isBadVersion(l) ? l : r;
    	}
    	int m=(l+r)/2;
    	if (isBadVersion(m) && !isBadVersion(m-1)) {
    		return l;
    	} else if (isBadVersion(m-1)) {
    		return helper(l,m-1,n);
    	} else {
    		return helper(m+1,r,n);
    	}
    }
}
