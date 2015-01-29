//zz reviewed

package zz;

public class LongestPalindroneSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String longestPalindrome(String s) {
		if(s==null || s.length()<=1){
			return s;
		}
		int start=0;
		int end=0;
		int len=s.length();
		boolean[][] isPa=new boolean[len][len];
		for(int i=0;i<len-1;i++){
			isPa[i][i]=true;
			if(s.charAt(i)==s.charAt(i+1)){//zz this block is unnessary, since d=2 is handled in the following code
				isPa[i][i+1]=true;
				start = i;
				end=i+1;
			}
		}

		isPa[len-1][len-1]=true;
		for(int d=2;d<len;d++){//zz what's the meaning of d?
			for(int i=0;i<len-d;i++){
				int j=i+d;
				if(isPa[i+1][j-1]&&s.charAt(i)==s.charAt(j)){
					isPa[i][j]=true;
					start=i;
					end=j;
				}
			}
		}
		return s.substring(start,end+1);
	}
}
