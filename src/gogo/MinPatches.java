package gogo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinPatches {//have better O(n) solution
    public int minPatches(int[] nums, int n) {
    	if (n<=0) return 0;
        long miss=1;
        long i=0;
        long count=0;
        while(miss<=n) {
            if (i<nums.length && nums[(int)i]<=miss) {
                miss+=nums[(int)i++];
            } else {
                miss+=miss;
                count++;
            }
        }
        return (int)count;
    	
        if (n<=0) return 0;
        boolean[] checked=new boolean[n];
        int count=0;
        List<List<Integer>> list=new LinkedList<> ();
        Map<List<Integer>, Integer> sum=new HashMap<> ();
        curSums(0, 0, nums, n, checked, new LinkedList<Integer> (), list, sum);
        
        for(int i=0;i<n; i++) {
        	if (!checked[i]) {
        		count++;
        		add(i+1,n,checked,list, sum);
        	}
        }
        return count;
    }
    
    private void curSums(int index, int sum, int[] nums, int n, boolean[] checked,List<Integer> buffer, List<List<Integer>> list, Map<List<Integer>, Integer> sumMap) {
    	if (index==nums.length) {
    		List<Integer> l=new LinkedList<Integer> (buffer);
    		list.add(l);
    		if (sum<=n) {
    			checked[sum-1]=true;
    		}
    		sumMap.put(l, sum);
    		return;
    	}
    	curSums(index+1,sum,nums,n,checked,buffer,list,sumMap);
    	sum+=nums[index];
    	buffer.add(nums[index]);
    	curSums(index+1,sum,nums,n,checked,buffer,list,sumMap);
    	buffer.remove(buffer.size()-1);
    }
    private void add(int val, int n, boolean[] checked, List<List<Integer>> list, Map<List<Integer>, Integer> sumMap) {
    	List<List<Integer>> added=new LinkedList<> ();
    	for(List<Integer> l: list) {
    		List<Integer> addNew=new LinkedList<> (l);
    		addNew.add(val);
    		int sum=sumMap.get(l);
    		sum+=val;
    		if (sum<n) {
    			checked[sum-1]=true;
    		}
    		sumMap.put(addNew, sum);
    		added.add(addNew);
    	}
    	list.addAll(added);
    }
}
