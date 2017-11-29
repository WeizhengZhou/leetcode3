package gogo;

import java.util.LinkedList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int n1=0;
        int c1=0;
        int n2=0;
        int c2=0;
        for (int i=0;i<nums.length;i++) {
        	int n=nums[i];
        	if (n==n1) {
        		c1++;
        	} else if (n==n2) {
        		c2++;
        	} else if (c1==0) {
        		n1=n;
        		c1++;
        	} else if (c2==0) {
        		n2=n;
        		c2++;
        	} else {
        		c1--;
        		c2--;
        	}
        }
        c1=0;
        c2=0;
        for (int i=0;i<nums.length;i++) {
        	int n=nums[i];
        	if (n==n1) c1++;
        	if (n==n2) c2++;
        }
        List<Integer> list=new LinkedList<> ();
        if (c1>nums.length/3) list.add(n1);
        if (c2>nums.length/3 && n1!=n2) list.add(n2);
        return list;
    }
}
