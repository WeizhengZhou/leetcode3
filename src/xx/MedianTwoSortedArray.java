package xx;

public class MedianTwoSortedArray {
	public double findMedianSortedArrays(int A[], int B[]) {
        if(A==null && B==null){
            return 0;
        }
        if(A==null || A.length==0){
            if(B.length%2==1){return B[B.length/2];}
            else{return (B[B.length/2-1]+B[B.length/2])/2.0;}
        }
        if(B==null || B.length==0){
            if(A.length%2==1){return A[A.length/2];}
            else{return (A[A.length/2-1]+A[A.length/2])/2.0;}
        }
        int lenA=A.length;
        int lenB=B.length;
        int[] longA=null;
        int[] shortA=null;
        if(lenA>lenB){longA=A;shortA=B;}
        else{longA=B;shortA=A;}
        if((lenA+lenB)%2==1){ return bsHelper(0,longA.length-1,longA,0,shortA.length-1,shortA,(lenA+lenB)/2+1);}
        else{return (bsHelper(0,longA.length-1,longA,0,shortA.length-1,shortA,(lenA+lenB)/2)+bsHelper(0,longA.length-1,longA,0,shortA.length-1,shortA,(lenA+lenB)/2+1))/2.0;}
	}
	
	private int bsHelper(int lA,int rA,int[] A,int lB,int rB, int[] B,int k){
	    if(lA>rA){return B[lB+k-1];}
	    if(lB>rB){return A[lA+k-1];}
	    if(k==1){return Math.min(A[lA],B[lB]);}
	    int kA=k/2;
	    int kB=Math.min(k-kA,rB-lB+1);
	    if(A[lA+kA-1]==B[lB+kB-1]){
	        return A[lA+kA-1];
	    }
	    else if(A[lA+kA-1]<B[lB+kB-1]){
	        return bsHelper(lA+kA,rA,A,lB,lB+kB-1,B,k-kA);
	    }
	    else{
	        return bsHelper(lA,lA+kA-1,A,lB+kB,rB,B,k-kB);
	    }
	}

}
