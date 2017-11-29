package gogo;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
        if (s1==null && s2==null || s1.length()==0 && s2.length()==0) return true;
        if (s1.length()!= s2.length()) return false;
        if (s1.length()==1) return s1.equals(s2);
        if (s1.equals(s2)) return true;
        int[][][] isS = new int[s1.length()][s1.length()][s1.length()];
        return helper(0,0,s1.length(),s1,s2,isS) > 0 ? true : false;
    }
	//"ab", "ba"
	
	private int helper(int x, int y, int len,String s1, String s2, int[][][] isS) {
		if (isS[x][y][len-1]!=0) {
			return isS[x][y][len-1];
		}
		String sub1=s1.substring(x,x+len);
		String sub2=s2.substring(y,y+len);
        if (sub1==null && sub2==null || sub1.length()==0 && sub2.length()==0) {
        	isS[x][y][len-1] = 1;
        	return 1;
        }
        if (len==1) {
        	isS[x][y][0] = sub1.equals(sub2) ? 1 : -1;
        	return isS[x][y][0];
        }
        if (sub1.equals(sub2)) {
        	isS[x][y][len-1] = 1;
        	return 1;
        }
        
        for (int i=1; i<len;i++) {
        	if (helper(x,y,i,s1,s2,isS)>0 && helper(x+i,y+i,len-i,s1,s2,isS)>0 ||
        			helper(x,y+len-i,i,s1,s2,isS)>0 && helper(x+i,y,len-i,s1,s2,isS)>0 
        	) {// 0,1,1,     1,0,1
        		isS[x][y][len-1]=1;
        		return 1;
        	}
        }
        isS[x][y][len-1]=-1;
        return -1;
	}
}
