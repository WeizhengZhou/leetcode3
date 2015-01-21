//zz reviewed
package zz;

import java.util.Arrays;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString in=new InterleavingString();
		System.out.println(in.isInterleave("a", "b", "ab"));

	}
	
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null||s2==null||s3==null||s3.length()!=s1.length()+s2.length()){
        	return false;
        }
        int s1len=s1.length();
        int s2len=s2.length();
        //int s3len=s3.length();
        boolean[][] isIn=new boolean[s1len+1][s2len+1];
        isIn[s1len][s2len]=true;
        for(int i=s1len-1;i>=0;i--){
        	isIn[i][s2len]=isIn[i+1][s2len]&&s1.charAt(i)==s3.charAt(i+s2len);
        }
        for(int i=s2len-1;i>=0;i--){//use j to refer column index
        	isIn[s1len][i]=isIn[s1len][i+1]&&s2.charAt(i)==s3.charAt(i+s1len);
        }
        for(int i=s1len-1;i>=0;i--){
        	for(int j=s2len-1;j>=0;j--){
        		boolean flag=false;
        		if(s1.charAt(i)==s3.charAt(i+j)){
        			flag|=isIn[i+1][j];
        		}
        		if(s2.charAt(j)==s3.charAt(i+j)){
        			flag|=isIn[i][j+1];
        		}
        		isIn[i][j]=flag;
        	}
        }
        System.out.println(Arrays.deepToString(isIn));
        return isIn[0][0];
    }

}
