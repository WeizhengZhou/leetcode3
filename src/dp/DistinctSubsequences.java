package dp;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctSubsequences d=new DistinctSubsequences();
		System.out.println(d.distinct("", "c"));

	}
	
	public int distinct(String S, String T){
		int[][] A=new int[S.length()+1][T.length()+1];
		if(S.length()==0||T.length()==0){
			return 0;
		}
		for(int i=0; i<=S.length();i++){
			A[i][0]=1;
		}
		for(int i=1; i<=T.length();i++){
			A[0][i]=0;
		}
		for(int i=1; i<=S.length();i++){
			for(int j=1; j<=T.length();j++){
				A[i][j]+=A[i-1][j];
				if(S.charAt(i-1)==T.charAt(j-1)){
					A[i][j]+=A[i-1][j-1];
					System.out.println("A["+i+"]["+j+"]="+A[i][j]);
				}
				
			}
		}
		return A[S.length()][T.length()];
	}

}
