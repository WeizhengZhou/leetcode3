package zz;

public class PermutationSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getPermutation(int n, int k) {
        if(n==0 || k==0){
        	return "";
        }
        int[] fact=new int[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++){
        	fact[i]=fact[i-1]*i;
        }
        int[] used=new int[n];
        StringBuilder resBuf=new StringBuilder();
        for(int i=0;i<n;i++){
        	//int nth=k/factorial
        }
    }


}
