//zz reviewed

package zz;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void merge(int A[], int m, int B[], int n) {
		//zz why not check m?
		//check A.length to hold two arrays
		if(A==null || B==null || A.length==0 || B.length==0 || n==0){
			return;
		}
		/* zz
		int i = m-1;
		 int j = n-1;
		 int k = m+n-1;
		 while(i >= 0 || j >= 0){
			 if(i < 0)
				 A[k--] = B[j--];				 
			 else if(j < 0)
				 A[k--] = A[i--];
			 else if(A[i] > B[j])
				 A[k--] = A[i--];
			 else
				 A[k--] = B[j--];			
		 }
		*/
		//zz, this problem is like merge two linked list
		int len=m+n-1;//zz len sounds like a constant, so does the m and n
			      //zz when these variables are changing indeices, use i,j,k,
		for(;len>=0;len--){
			//int d=0;
			if(m>=0 && n>=0){
				A[len]=Math.max(A[m-1], B[n-1]);
				if(A[len]==A[m-1]){
					m--;
				}
				else{
					n--;
				}
			}
			else{//zz this if-else is only used to terminate the for-loop, why not use a while loop 
			     //while(m>=0 && n>=0){len--;}
				break;
			}
		}
		
		int[] remain=m==0?B:A;
		int l=m==0?n:m;
		for(;l>0;l--){
			//len--;
			A[len--]=remain[l-1];
		}
	}

}
