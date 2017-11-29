package gogo;

import java.util.Arrays;
import java.util.LinkedList;

public class PalindromePartitionII {
	public static void main(String[] args) {
		PalindromePartitionII p = new PalindromePartitionII();
		System.out.println(p.minCut("aab"));
	}
    public int minCut(String s) {
    	if (s==null || s.length() ==0) return 0;
    	boolean[][] isP = new boolean[s.length()][s.length()];
    	isP[0][0]=true;
    	for (int i=1;i<s.length();i++){
    		isP[i][i]=true;
    		isP[i-1][i] = s.charAt(i-1)==s.charAt(i);
    	}
    	for(int d=2;d<s.length();d++){
    		for(int i=0;i<s.length()-d;i++) {
    			isP[i][i+d] = isP[i+1][i+d-1] && s.charAt(i)==s.charAt(i+d);
    		}
    	}
    	int[] minC = new int[s.length()];
    	minC[0]=0;
    	for (int i=1;i<s.length();i++) {
    		int min=i;
    		if (isP[0][i]) {
    			min=0;
    		} else {
    			for (int j=1;j<=i;j++) {
    				if (isP[j][i]) {
    					min=Math.min(min, 1+minC[j-1]);
    				}
    			}
    		}
    		minC[i]=min;
    	}
    	System.out.println(Arrays.toString(minC));
    	return minC[s.length()-1];
    }
}
