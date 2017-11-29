package gogo;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes==null || primes.length==0 || n<=0) return 0;
        if(n==1) return 1;
        int[] ugly=new int[n];
        ugly[0]=1;
        int[] index=new int[primes.length];
        for(int i=1;i<n;i++) {
        	int min=Integer.MAX_VALUE;
        	for(int j=0;j<primes.length;j++) {
        		min=Math.min(min, primes[j]*ugly[index[j]]);
        	}
        	for(int j=0;j<primes.length;j++) {
        		if (min==primes[j]*ugly[index[j]]) index[j]++;
        	}
        	ugly[i]=min;
        }
        return ugly[n-1];
    }
    public int nthSuperUglyNumberII(int n, int[] primes) {
        if (primes==null || primes.length==0 || n<=0) return 0;
        if(n==1) return 1;
        PriorityQueue<Integer> q=new PriorityQueue<> ();
        q.add(1);
        int cur=1;
        Set<Integer> set=new HashSet<> ();
        set.add(1);
        for(int i=1;i<n;i++){
        	cur=q.poll();
        	set.remove(cur);
        	for(Integer p:primes) {
        		int mul=p*cur;
        		if (!set.contains(mul)) {
        			q.add(mul);
        			set.add(mul);
        		}
        	}
        }
        return q.poll();
    }
}
