package additional;

public class NumberTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberTarget n=new NumberTarget();
		System.out.println(n.getNumber(new int[]{1,2,2,2,3,4,5}, 2));

	}
	
	public int getNumber(int[] A, int target){
		if(A==null || A.length==0){
			return 0;
		}
		int left=bs(0,A.length-1,A,target,true);
		if(left==-1){
			return 0;
		}
		int right=bs(0,A.length-1,A,target,false);
		return right-left+1;
	}
	
	public int bs(int l, int r, int[] A, int target, boolean left){
		if(l==r){
			if(A[l]==target){
				return l;
			}
			else{
				return -1;
			}
		}
		int m=l+(r-l)/2;
		if(left){
			if(A[m]==target && (m-1<0 || A[m-1]<target)){
				return m;
			}
			if(A[m]<target){
				return bs(m+1,r,A,target,left);
			}
			else{
				return bs(l,m-1,A,target,left);
			}
		}
		else{
			if(A[m]==target && (m+1>=A.length || A[m+1]>target)){
				return m;
			}
			if(A[m]>target){
				return bs(l,m-1,A,target,left);
			}
			else{
				return bs(m+1,r,A,target,left);
			}
		}
	}

}
