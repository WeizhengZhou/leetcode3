package xx;

public class ScrambleString {
	public boolean isScramble(String s1, String s2){
		if(s1==null || s2==null || s1.length()!=s2.length()){return false;}
		int len=s1.length();
		boolean[][][] sub=new boolean[len][len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				sub[i][j][0]=s1.charAt(i)==s2.charAt(j);
			}
		}
		for(int d=1;d<len;d++){
			for(int i=0;i<len-d;i++){
				for(int j=0;j<len-d;j++){
					for(int k=0;k<d;k++){
						if(sub[i][j][k]&&sub[i+k+1][j+k+1][d-k-1] || sub[i][j+d-k][k] && sub[i+k+1][j][d-k-1])
						{
							sub[i][j][d]=true; 
							break; 
						}
					}
				}
			}
		}
		return sub[0][0][len-1];

	}
}
