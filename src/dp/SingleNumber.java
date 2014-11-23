package dp;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int singleNumber(int[] A) {
        if(A==null||A.length==0){
        	return 0;
        }
        int sum=0;
        for(int i=0;i<A.length;i++){
        	sum=sum^A[i];
        }
        return sum;
    }
}
