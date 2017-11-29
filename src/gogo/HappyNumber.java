package gogo;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        if (n==0) return false;
        n=n<0?-n:n;
        Set<Integer> set=new HashSet<> ();
        set.add(n);
        int cur=n;
        while(cur!=1){
        	int sum=0;
        	while(cur>0) {
        		sum+=(cur%10)*(cur%10);
        		cur=cur/10;
        	}
        	if (set.contains(sum)) return false;
        	set.add(sum);
        	cur=sum;
        }
        return cur==1;
    }
}
