package zz;

public class MedianSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public double findMedianSortedArrays(int A[], int B[]) {
        if(A==null && B==null){
        	return 0;
        }
        if(A==null || B==null){
        	int[] validA=A==null?B:A;
        	int len=validA.length;
        	if(len%2==1){
        		return validA[len/2];
        	}
        	else{
        		return((validA[len/2]+validA[len/2+1])/2);
        	}
        }
        int n=A.length;
        int m=B.length;
        int[] longA;
        int[] shortA;
        if(n>=m){
        	longA=A;
        	shortA=B;
        }
        else{
        	longA=B;
        	shortA=A;
        }
        if((m+n)%2==1){
        	return findKthSmallest(longA,0,longA.length-1,shortA,0,shortA.length-1,(m+n)/2+1);      	
        }
        else{
        	double first=findKthSmallest(longA,0,longA.length-1,shortA,0,shortA.length-1,(m+n)/2);      	
        	double second=findKthSmallest(longA,0,longA.length-1,shortA,0,shortA.length-1,(m+n)/2+1); 
        	return (first+second)/2;
        }
    }

	public double findKthSmallest(int[] A,int la,int ra,int[] B,int lb, int rb, int k){
		if(lb>rb){
			return A[la+k-1];
		}
		if(la>ra){
			return B[lb+k-1];
		}
		if(k==1){
			return Math.min(A[la], B[lb]);
		}
		int ka=k/2;
		int kb=Math.min(k-ka, rb-lb+1);
		if(A[la+ka-1]==B[lb+kb-1]){
			return A[la+ka-1];
		}
		else if(A[la+ka-1]>B[lb+kb-1]){
			return findKthSmallest(A,la,la+ka-1,B,lb+kb,rb,k-kb);
		}
		else{
			return findKthSmallest(A,la+ka,ra,B,lb,lb+kb-1,k-ka);
		}
	}

}
