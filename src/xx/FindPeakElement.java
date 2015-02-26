package xx;

public class FindPeakElement {
	public int findPeakElement(int[] num) {
        if(num==null || num.length==0){return 0;}
        return bsHelper(0,num.length-1,num);
    }
    private int bsHelper(int l,int r,int[] A){
        if(l==r)return l;
        if(l+1==r){return A[l]>A[r]?l:r;}
        int m=l+(r-l)/2;
        if(A[m]>A[m-1]&&A[m]>A[m+1]){return m;}
        else if(A[m]<A[m+1]){return bsHelper(m+1,r,A);}
        else{return bsHelper(l,m-1,A);}
    }
}
