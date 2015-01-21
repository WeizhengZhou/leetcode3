//zz reviewed

package zz;

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int climbStairs(int n) {
        if(n<=0){
        	return 0;
        }
		//zz, you only need to check n<0,
		//all other cases will be handled correctly by the following code
		//for example, when n=1, the for loop will be skipped, and return ways[n=0] = 0;
        if(n==1){
        	return 1;
        }
        if(n==2){
        	return 2;
        }
        int[] ways=new int[n+1];
        ways[0]=0;
        ways[1]=1;
        ways[2]=2;
        for(int i=3;i<=n;i++){
        	ways[i]=ways[i-1]+ways[i-2];
        }
        return ways[n];
    }

}
