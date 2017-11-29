package gogo;

public class CitationsII {
    public int hIndex(int[] citations) {
        if (citations==null || citations.length==0) return 0;
        return helper(0, citations.length-1,citations);
    }
    
    private int helper(int l, int r, int[] citations) {
    	if (l>r) return 0;
    	if (l==r) {
    		int len=citations.length-l;
    		if (citations[l]>=len) return len;
    		return 0;
    	}
    	if (l+1==r) {
    		int len=citations.length-l;
    		if (citations[l]>=len) return len;
    		return citations[r]>=len-1 ? len-1 : 0;
    	}
    	int m=(l+r)/2;
    	int len=citations.length-m;
    	if (citations[m]>=len) {
    		if (citations[m-1]>=len+1) {
    			return helper(l,m-1,citations);
    		}
    		return len;
    	} else {
    		return helper(m+1,r,citations);
    	}
    }
}
