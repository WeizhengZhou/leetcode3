package dp;

import java.util.Arrays;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays d=new DecodeWays();
		System.out.println(d.DecodeWays("101"));
		//System.out.println("10".substring(0,1));
	}
	
	public int DecodeWays(String s){
		if (s==null||s.length()==0){return 0;}
		int[] A=new int[s.length()];
		if (Integer.decode(s.substring(0,1))==0){
			return 0;
		}
		A[0]=1;
		for (int i=1; i<s.length();i++){
			int num=Integer.decode(s.substring(i,i+1));
			if (num>0){
				A[i]+=A[i-1];
			}	
			int num2=10*Integer.decode(s.substring(i-1,i))+Integer.decode(s.substring(i,i+1));
			if( num2<=26 && num2>9){
			
				if(i<=2){
					A[i]++;
				}
				else{
					A[i]+=A[i-2];
				}
			}
			if(A[i]==0) {
				return 0;
			}
			 System.out.println(Arrays.toString(A));
		}
		
		return A[s.length()-1];
	}

}
