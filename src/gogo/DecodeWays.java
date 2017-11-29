package gogo;

public class DecodeWays {
    public int numDecodings(String s) {
    	if (s==null ||s.length()==0) return 0;
        if (s.length()==1) return s.charAt(0)>'0' ? 1: 0;
        int len = s.length();
        int[] ways = new int[len+1];
        ways[0] = 1;
        ways[1]= s.charAt(0)>'0' ? 1: 0;
        for(int i=2;i<=len;i++) {
        	String two = s.substring(i-2,i);
        	int twoDigits = Integer.parseInt(two);
        	int n = twoDigits <= 26 && twoDigits >=10 ? ways[i-2] : 0;
        	int oneDigit = s.charAt(i-1) > '0' ? ways[i-1] : 0;
        	ways[i] = n + oneDigit;
        }
        return ways[len];
    }
}
