package dp;

public class MedianSortedArray {

	public double findMedianSortedArrays(int[] A, int[] B){
    	if(A == null || B == null) return 0;
	    int m = A.length;
        int n = B.length;
        if((m+n)%2 == 1) 
			return findKthSmall(A,0,m-1,B,0,n-1,(m+n)/2+1);
        else
            return (findKthSmall(A,0,m-1,B,0,n-1,(m+n)/2) + 
                   findKthSmall(A,0,m-1,B,0,n-1,(m+n)/2+1))/2.0;	
        
	}
    private int findKthSmall(int[] A, int la, int ra, int[] B, int lb, int rb, int k){
    	System.out.println("la = "+ la + ", ra = " + ra + ", lb = " + lb + ", rb = " + rb + ", k = "+ k);
		if(la > ra) return B[lb+k-1];
        if(lb > rb) return A[la+k-1];
        if(ra-la < rb-lb) return findKthSmall(B,lb,rb,A,la,ra,k);//A has a longer length
        if(k==1) return Math.min(A[la],B[lb]);//avoid k=1, ka = 0, A[la+ka-1] out of boundary
        int ka = k/2;
        int kb = Math.min(k-ka,rb-lb+1);
        if(A[la+ka-1] == B[lb+kb-1]) 
			return A[la+ka-1];
        else if(A[la+ka-1] < B[lb+kb-1])
 			return findKthSmall(A,la+ka,ra,B,lb,lb+kb-1,k-ka);//lb+kb-1 should be included for search, 
        else 
			return findKthSmall(A,la,la+ka-1,B,lb+kb,rb,k-kb); 
	} 

    public static void main(String[] args){
//		int[] A = new int[]{100001};
//		int[] B = new int[]{100000};
    	int[] A = new int[]{1,2,4,5};
    	int[] B = new int[]{1,3,5,7};
		MedianSortedArray s = new MedianSortedArray();
		System.out.println(s.findMedianSortedArrays(A,B));
		
	}

}
