package additional;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> maxList=new LinkedList<> ();
        if (nums==null || nums.length<=0) return maxList;
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        dp[0]=1;
        int[] back=new int[nums.length];
        back[0]=0;
        int index=0;
        int max=0;
        for(int i=1;i<nums.length;i++) {
        	int cur=nums[i];
        	int m=0;
        	int in=i;
        	for(int j=0;j<i;j++) {
        		if (cur % nums[j] ==0) {
        			if (dp[j]>m) {
        				m=dp[j];
        				in=j;
        			}
        		}
        		
        	}
        	dp[i]=m+1;
        	back[i]=in;
        	if (m+1>max) {
        		max=m+1;
        		index=i;
        	}
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(back));
        while(index!=back[index]) {
        	maxList.add(0,nums[index]);
        	index=back[index];
        }
        if (maxList.isEmpty() || maxList.get(0)%nums[index] == 0) maxList.add(0,nums[index]);
        return maxList;
    }
}
