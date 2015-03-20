package xx;

public class PalindromePartitionII {
	public int minCut(String s) {
        if(s==null || s.length()==0){return 0;}
        int len=s.length();
        boolean[][] isPa=new boolean[len][len];
        for(int i=0;i<len-1;i++){
            isPa[i][i]=true;
            isPa[i][i+1]=s.charAt(i)==s.charAt(i+1);
        }
        isPa[len-1][len-1]=true;
        for(int d=2;d<len;d++){
            for(int i=0;i<len-d;i++){
                int j=i+d;
                isPa[i][j]=isPa[i+1][j-1]&&s.charAt(i)==s.charAt(j);
            }
        }
        int[] nCut=new int[len];
        for(int i=0;i<len;i++){
            if(isPa[0][i]){nCut[i]=0;continue;}
            int min=Integer.MAX_VALUE;
            for(int j=i;j>0;j--){
                if(isPa[j][i]){min=Math.min(min,nCut[j-1]+1);}
            }
            nCut[i]=min;
        }
        return nCut[len-1];
    }
}
