package xx;

import java.util.Arrays;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString inter=new InterleavingString();
		System.out.println(inter.isInterleave("aabc", "abad", "aabadabc"));
	}
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null || s2==null || s3==null || s1.length()+s2.length()!=s3.length())return false;
        int len1=s1.length();
        int len2=s2.length();
        boolean[][] isInter=new boolean[len1+1][len2+1];
        isInter[0][0]=true;
        for(int i=1;i<len1+1;i++){isInter[i][0]=s1.substring(0,i).equals(s3.substring(0,i));}
        for(int j=1;j<len2+1;j++){isInter[0][j]=s2.substring(0,j).equals(s3.substring(0,j));}
        for(int i=1;i<len1+1;i++){
            for(int j=1;j<len2+1;j++){
                if(s1.charAt(i-1)==s3.charAt(i+j-1)&&isInter[i-1][j]){
                    isInter[i][j]=true;
                    //continue;
                }
                else if (s2.charAt(j-1)==s3.charAt(i+j-1) && isInter[i][j-1]){
                    isInter[i][j]=true;
                    //continue;
                }
                else{isInter[i][j]=false;}
            }
        }
        for(int i=0;i<isInter.length;i++){
        	System.out.println(Arrays.toString(isInter[i]));
        }
        
        return isInter[len1][len2];
    }
}
