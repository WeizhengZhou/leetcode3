package gogo;

public class LongestValidParen {
	public int longestValidParentheses(String s) {
		if (s==null || s.length()<2) return 0;
        int[] isValid = new int[s.length()];
        isValid[0] = 0;
        isValid[1] = s.charAt(0) == '(' && s.charAt(1) == ')' ? 2 : 0;
        int max = isValid[1];
        for (int i=2; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '(') {
        		isValid[i] = 0;
        	} else {
        		char pre = s.charAt(i-1);
        		if (pre == '(') {
        			isValid[i] = isValid[i-2] + 2;
        		} else {
        			int preValid = i-isValid[i-1]-1;
        			boolean valid = preValid >=0 && s.charAt(preValid) == '(';
        			int preLen = preValid > 0 ? isValid[preValid-1]: 0;
        			isValid[i] = valid ? preLen + isValid[i-1] + 2 : 0;
        		}
        	}
        	max = Math.max(max, isValid[i]);
        }
        return max;
    }
}
