//zz reviewed

package zz;

import java.util.Arrays;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays d=new DecodeWays();
		System.out.println(d.numDecodings("12120"));

	}
	
	public int numDecodings(String s) {
		if(s==null || s.length()==0){
			return 0;
		}
		if(s.length()==1){
			return s.equals("0")?0:1;
		}
		int len=s.length();
		int[] ways=new int[len];
		ways[len-1]=s.charAt(len-1)=='0'?0:1;
		if(s.charAt(len-2)!='0'){
			int lastTwo=Integer.parseInt(s.substring(len-2));
			if(lastTwo>26){
				ways[len-2]=ways[len-1];
			}
			else if(lastTwo==10 || lastTwo==20){
				ways[len-2]=1;
			}
			else {
				ways[len-2]=2;
			}
		}
		for(int i=len-3;i>=0;i--){
			if(s.charAt(i)!='0'){
				ways[i]=ways[i+1];
				if (Integer.parseInt(s.substring(i,i+2))<=26){
					ways[i]+=ways[i+2];
				}
			}			
		}
		System.out.println(Arrays.toString(ways));
		return ways[0];
	}

}
