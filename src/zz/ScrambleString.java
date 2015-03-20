//zz reviewed
package zz;

import java.util.Arrays;

public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString s=new ScrambleString();
		System.out.println(s.isScramble("ab", "ba"));

	}
	
    public boolean isScramble(String s1, String s2) {
        if(s1==null || s2==null ||s1.length()==0 || s2.length()==0 || s1.length()!=s2.length()){
        	return false;
        }
        boolean[][][] isSubSramble=new boolean[s1.length()][s2.length()][s1.length()];
        for(int i=0;i<s1.length();i++){
        	for(int j=0;j<s2.length();j++){
        		if(s1.charAt(i)==s2.charAt(j)){
        			isSubSramble[i][j][0]=true;
        		}
        	}
        }
        for(int len=1;len<s1.length();len++){
        	for(int i=0;i<s1.length()-len;i++){
        		for(int j=0;j<s1.length()-len;j++){
        			for(int k=0;k<len;k++){
        				if(isSubSramble[i][j][k]&&isSubSramble[i+k+1][j+k+1][len-k-1]){
        					isSubSramble[i][j][len]=true;
        				}
        				if(isSubSramble[i][j+len-k][k]&&isSubSramble[i+k+1][j][len-k-1]){
        					isSubSramble[i][j][len]=true;
        				}
        			}
        		}
        	}
        	//System.out.println(Arrays.deepToString(isSubSramble[]));
        }
        return isSubSramble[0][0][s1.length()-1];
    }

}
