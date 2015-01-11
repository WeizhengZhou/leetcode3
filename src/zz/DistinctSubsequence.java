package zz;

public class DistinctSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int numDistinct(String S, String T) {
        if(S==null || T==null ||S.length()==0 ||T.length()==0||S.length()<T.length()){
        	return 0;
        }
        int[][] num=new int[S.length()+1][T.length()+1];
        int slen=S.length();
        int tlen=T.length();
        num[slen][tlen]=1;
        num[slen][tlen-1]=0;
        num[slen-1][tlen]=0;
        //num[slen-1][tlen-1]=S.charAt(slen-1)==T.charAt(tlen-1)?1:0;
        for(int i=slen-1;i>=0;i--){
        	num[i][tlen]=1;
        	for(int j=tlen-1;j>=0;j--){
        		num[i][j]=num[i+1][j];
        		if(S.charAt(i)==T.charAt(j)){
        			num[i][j]+=num[i+1][j+1];
        		}
        	}
        }
        return num[0][0];
    }

}
