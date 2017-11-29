package gogo;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s==null && p==null || s.length() ==0 && p.length()==0) return true;
		if (p.length() == 0) return false;
		boolean[][] isM = new boolean[s.length() + 1][p.length() + 1];
		isM[0][0] = true;
		isM[0][1] = p.charAt(0) == '*';
		
		for(int i=2;i<=p.length();i++){
			isM[0][i] = isM[0][i-1] && p.charAt(i-1) == '*';
		}
		
		for (int i=1; i<=s.length();i++) {
			int sIndex = i-1;
			char sChar = s.charAt(sIndex);
			for(int j=1;j<=p.length();j++) {
				int pIndex=j-1;
				char pChar = p.charAt(pIndex);
				if (pChar!= '?' && pChar!='*') {
					isM[i][j] = sChar ==pChar && isM[i-1][j-1]; continue;
				}
				if (pChar == '?') {
					isM[i][j] = isM[i-1][j-1]; continue;
				}
				for (int k = 0; k<=i;k++) { 
					isM[i][j] = isM[i][j] || isM[k][j-1]; 
				}
			}
		}
		return isM[s.length()][p.length()];
    }
}
