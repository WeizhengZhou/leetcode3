package zz;

import java.util.LinkedList;
import java.util.List;

public class PalindromePatitionII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePatitionII p=new PalindromePatitionII();
		System.out.println(p.minCut("abba"));

	}
	
    public int minCut(String s) {
    	//List<List<String>> res=new LinkedList<List<String>>();
        if(s==null || s.length()==0){
        	return 0;
        }
        boolean[][] isPa=new boolean[s.length()][s.length()];
        isPa[0][0]=true;
        for(int i=1;i<s.length();i++){
        	isPa[i][i]=true;
        	if(s.charAt(i-1)==s.charAt(i)){
        		isPa[i-1][i]=true;
        	}
        }
        for(int d=2;d<s.length();d++){
        	for(int i=0;i<s.length()-d;i++){
        		int j=i+d;
        		if(isPa[i+1][j-1] && s.charAt(i)==s.charAt(j)){
        			isPa[i][j]=true;
        		}
        	}
        }
        //int min=helper(0,s,isPa);
        //return min;
        int[] minCut=new int[s.length()];
        minCut[0]=0;
        for(int i=0;i<s.length();i++){
        	if(isPa[0][i]){
        		minCut[i]=0;
        		continue;
        	}
        	int min=s.length();
        	for(int j=1;j<=i;j++){
        		if(isPa[j][i]){
        			min=Math.min(min, minCut[j-1]+1);
        		}
        	}
        	minCut[i]=min;
        }
        return minCut[s.length()-1];
    }
   

	//zz not used method 
    public int helper(int start, String s, boolean[][] isPa ){
    	int min=s.length();
    	if(isPa[start][s.length()-1]){
    		return 0;
    	}
    	for(int i=start; i<s.length(); i++){
    		if(isPa[start][i]){
    			int cut=1+helper(i+1,s,isPa);
    			min=Math.min(min, cut);
    		}
    	}
    	return min;
    }

}
