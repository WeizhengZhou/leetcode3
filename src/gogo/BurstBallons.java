package gogo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BurstBallons {
	Map<List<Integer>, Integer> map;
	int[][] memo;
	public int maxCoins(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int[] n=new int[nums.length+2];
        n[0]=1;
        n[n.length-1]=1;
        for(int i=1;i<=nums.length;i++) {
        	n[i]=nums[i-1];
        }
        memo=new int[n.length][n.length];
        return cal(0,n.length,n);
    }
	
	private int cal(int l, int r, int[] n) {
		if (l+1==r) return 0;
		if (memo[l][r]>0) return memo[l][r];
		if (l+2==r) {
			memo[l][r]=n[l]*n[l+1]*n[r];
			return memo[l][r];
		}
		int max=0;
		for(int i=l+1;i<r;i++) {
			max=Math.max(max, n[i]*n[l]*n[r] + cal(l,i,n) + cal(i,r,n));
		}
		memo[l][r]=max;
		return max;
	}
	
    public int maxCoinsII(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        List<Integer> list=new LinkedList<> ();
        for(int i=0;i<nums.length;i++) {
        	if (nums[i]!=0) list.add(nums[i]);
        }
        if (list.isEmpty()) return 0;
        map=new HashMap<> ();
        return helper(list);     
    }
    
    private int helper(List<Integer> list) {
    	int sum=0;
    	if (map.containsKey(list)) return map.get(list);
    	if (list.size()==1) {
    		map.put(list, list.get(0));
    		return list.get(0);
    	}
    	if (list.size()==2) {
    		sum= list.get(0)*list.get(1)+Math.max(list.get(0), list.get(1));
    		map.put(list, sum);
    		return sum;
    	}
    	for(int i=0;i<list.size();i++) {
        	int mul=0;
        	int cur=list.get(i);
        	if (i==0) {
        		mul=cur*list.get(1);
        	} else if (i==list.size()-1) {
        		mul=cur*list.get(i-1);
        	} else {
        		mul=cur*list.get(i-1)*list.get(i+1);
        	}
        	list.remove(i);
        	sum=Math.max(sum, mul+helper(list));
        	list.add(i, cur);
        }
    	map.put(list, sum);
        return sum;
    }
}
