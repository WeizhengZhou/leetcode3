package gogo;

public class StringToInteger {
	public static void main(String[] args) {
		StringToInteger s=new StringToInteger();
		System.out.println(s.myAtoi("    -00134"));
	}
	public int myAtoi(String str) {
		if (str == null || str.length() == 0) return 0;
        String s = str.trim();
        int re = 0;
        boolean isPo=true;
        boolean isSet=false;
        for (int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if (c== ' ') return isPo ? re : -re;
        	if (c=='-') {
        		if (isSet) return 0;
        		isPo = false;
        		isSet = true;
                continue;
        	}
        	if (c=='+') {
        		if (isSet) return 0;
        		isPo=true;
        		isSet=true;
                continue;
        	}
        	if (c>='0' && c<='9') {
                if (isPo && re > ((Integer.MAX_VALUE-(c-'0')))/10) return Integer.MAX_VALUE;
                if (!isPo && re > -((Integer.MIN_VALUE+(c-'0'))/10)) return Integer.MIN_VALUE;

        		re = re*10 + c-'0'; 
                continue;
        	}
        	return isPo ? re : -re;   	
        }
        return isPo ? re : -re;
    }

}
