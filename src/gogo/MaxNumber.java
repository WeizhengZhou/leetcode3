package gogo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]
 * */
/*
 * [2,5,6,4,4,0]
[7,3,8,0,6,5,7,6,2]
15
expect: [7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]

[5,0,2,1,0,1,0,3,9,1,2,8,0,9,8,1,4,7,3]
[7,6,7,1,0,1,0,5,6,0,5,0]
31
[7,6,7,5,1,0,2,1,0,1,0,5,6,0,5,0,1,0,3,9,1,2,8,0,9,8,1,4,7,3,0]

[1,0,1,2,0,0,0,2,0,1,0,1,2,0,0,2,1,1,1,2,1,0,0,0,0,2,1,1,1,1,1,1,0,2,2,1,2,0,1,2,2,0,1,2,1,2,0,2,0,2]
[2,0,2,2,2,0,2,0,1,1,2,2,1,2,1,1,0,0,0,0,1,2,0,1,0,1,0,1,1,0,2,1,0,0,2,1,2,0,0,1,1,0,2,1,2,2,2,0,1,2]
100

 * */
public class MaxNumber {
	public static void main(String[] args) {
		MaxNumber m=new MaxNumber();
		int[] r1=m.maxNumber(
				new int[] {1,0,1,2,0,0,0,2,0,1,0,1,2,0,0,2,1,1,1,2,1,0,0,0,0,2,1,1,1,1,1,1,0,2,2,1,2,0,1,2,2,0,1,2,1,2,0,2,0,2}, 
				new int[] {2,0,2,2,2,0,2,0,1,1,2,2,1,2,1,1,0,0,0,0,1,2,0,1,0,1,0,1,1,0,2,1,0,0,2,1,2,0,0,1,1,0,2,1,2,2,2,0,1,2}, 
				100);
		System.out.println(Arrays.toString(r1));	
	}
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] r=new int[k];
        if (nums1==null || nums2==null || nums1.length+nums2.length<k) return r;
        Map<Integer,Integer> map1=new HashMap<> ();
        for(int i=0;i<nums1.length;i++) {
        	map1.put(nums1[i],i);
        }
        Map<Integer,Integer> map2=new HashMap<> ();
        for(int i=0;i<nums2.length;i++) {
        	map2.put(nums2[i],i);
        }
        for(int i=0;i<=Math.min(nums1.length, k);i++) {
        	if(k-i>=0 && k-i<=nums2.length) {
        		int[] a1=new int[i];//build(nums1,i,map1,n1);
        		int[] a2=new int[k-i];//build(nums2,k-i,map2,n2);
        		helper(nums1,a1,0,0);
        		helper(nums2,a2,0,0);
        		int[] m=merge(a1,a2);
        		if (greater(m,0,r,0)) {
        			r=m;
        		}
        	}
        }
        return r;
    }

    private void helper(int[] nums, int[] r, int index, int rIndex) {
    	if (rIndex==r.length) return;
    	int max=-1;
    	int maxIndex=-1;
    	for(int i=index;i<nums.length;i++) {
    		int c=nums[i];
    		if (c>max && nums.length-i>=r.length-rIndex) {
    			max = c;
    			maxIndex=i;
    		}
    	}
    	r[rIndex] = max;
		rIndex++;
		helper(nums,r,maxIndex+1,rIndex);
    }
    private int[] merge(int[] n1, int[] n2) {
    	int[] r=new int[n1.length+n2.length];
    	int i=0;
    	int j=0;
    	int in=0;
    	while(i<n1.length && j<n2.length) {
    		r[in++]=greater(n1,i,n2,j)?n1[i++]:n2[j++];
    	}
    	while(i<n1.length) {
    		r[in++]=n1[i++];
    	}
    	while(j<n2.length) {
    		r[in++]=n2[j++];
    	}
    	return r;
    }

    private boolean greater(int[] a1, int i1, int[] a2, int i2) {
    	
    	while(i1<a1.length && i2<a2.length && a1[i1]==a2[i2]) {
    		i1++;
    		i2++;
    	}
    	return i2==a2.length || (i1<a1.length && a1[i1]>a2[i2]);
    }
}
