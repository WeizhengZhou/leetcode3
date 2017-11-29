package gogo;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n<=2) return 0;
        boolean[] comp = new boolean[n];
        comp[0] = true;
        comp[1] = true;
        int count=0;
        for (int i=2;i<=n;i++) {
        	if (!comp[i]) {
        		for (int j=1;j<=n/(i+1);j++) {
        			comp[j*(i+1)] = true;
        		}
        		count++;
        	}
        }
        return count;
    }
}
