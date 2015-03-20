package xx;

public class DistinctSubsequence {
	public int numDistinct(String S, String T) {
	     if(S==null || S.length()==0 || T==null || T.length()==0)return 0;
	     int[][] nWays=new int[S.length()+1][T.length()+1];
	     for(int i=0;i<S.length();i++){
	         nWays[i][0]=1;
	     }
	     for(int i=1;i<=S.length();i++){
	         for(int j=1;j<=T.length();j++){
	             nWays[i][j]=nWays[i-1][j];
	             if(S.charAt(i-1)==T.charAt(j-1))nWays[i][j]+=nWays[i-1][j-1];
	         }
	     }
	    return nWays[S.length()][T.length()];
	    }
}
