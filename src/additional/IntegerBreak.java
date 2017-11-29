package additional;

public class IntegerBreak {
	public static void main(String[] args) {
		IntegerBreak i=new IntegerBreak();
		System.out.println(i.integerBreak(10));
	}
    public int integerBreak(int n) {
    	if (n<=0) return 0;
        if (n<=2) return 1;
        int[] ways=new int[n+1];
        ways[1]=1;
        for(int i=2;i<=n;i++) {
        	int sum=0;
        	for(int j=1;j<=i/2;j++) {
        		sum=Math.max(sum, Math.max(j, ways[j]) * Math.max(i-j, ways[i-j]));
        	}
        	ways[i]=sum;
        }
        return ways[n];
    }
}
