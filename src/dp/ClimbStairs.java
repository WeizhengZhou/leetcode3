package dp;

import java.util.Arrays;

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbStairs c=new ClimbStairs();
		System.out.println(c.ways(3));
	}
	
	public int ways(int n){
		if(n==0){
			return 0;
		}
		int[] ways=new int[n];
		ways[0]=1;
		if(n>=2){
			ways[1]=2;
		}
		
		for(int i=2;i<n;i++){
			ways[i]=ways[i-1]+ways[i-2];
		}
		System.out.println(Arrays.toString(ways));
		return ways[n-1];
	}

}
