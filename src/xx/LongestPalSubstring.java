package xx;

public class LongestPalSubstring {
	public String longestPalindrome(String s) {
        if(s==null || s.length()==0)return "";
        int len=s.length();
        boolean[][] isPa=new boolean[len][len];
        int start=0;
        int end=0;
        for(int i=0;i<len-1;i++){
            isPa[i][i]=true;
            isPa[i][i+1]=s.charAt(i)==s.charAt(i+1);
            if(isPa[i][i+1]){start=i;end=i+1;}
        }
        isPa[len-1][len-1]=true;
        for(int d=2;d<len;d++){
            for(int i=0;i<len-d;i++){
                int j=i+d;
                isPa[i][j]=isPa[i+1][j-1]&&s.charAt(i)==s.charAt(j);
                if(isPa[i][j]){start=i;end=j;}
            }
        }
        return s.substring(start,end+1);
    }

}
