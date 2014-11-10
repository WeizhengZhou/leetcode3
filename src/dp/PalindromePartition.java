package dp;

import java.util.Arrays;

public class PalindromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartition p=new PalindromePartition();
		int cut=p.minCut("dde");
		System.out.println(cut);

	}
	
	public int minCut(String s){
		int len=s.length();
		boolean[][] isPal=new boolean[len][len];
		for (int i=0;i<len;i++){
			isPal[i][i]=true;
		}
		for(int j=0;j<len-1;j++){
			if(s.charAt(j)==s.charAt(j+1)){
				isPal[j][j+1]=true;
			}
		}
		for (int d=2;d<len;d++){
			for(int i=0;i<len-d;i++){
				int j=i+d;
				isPal[i][j]=isPal[i+1][j-1]&&s.charAt(i)==s.charAt(j);
			}
		}
		
		System.out.println(Arrays.deepToString(isPal));
		int[] minCut=new int[len];
		for(int i=0;i<len;i++){
			minCut[i]=-1;
		}
		//System.out.print(Arrays.toString(minCut));
		return helper(isPal,0,minCut);
	}
	
	public int helper(boolean[][] check, int l,int[] minCut){
		if (minCut[l]>=0){
			return minCut[l];
		}
		if (check[l][check[0].length-1]){
			minCut[l]=0;
			return 0;
		}
		int min=Integer.MAX_VALUE;
		for(int i=0; i<check[0].length;i++){
			if(check[l][i]){
				int cut=1+helper(check,i+1,minCut);
				min=Math.min(min, cut);
			}
		}
		System.out.println("l="+l+",min="+min);
		minCut[l]=min;
		return min;
	}

}
