package gogo;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1==null || nums2==null) return;
        int x=m-1;
        int y=n-1;
        for(int i=m+n-1;i>=0;i--) {
        	if (x>=0 && y>=0) {
        		if (nums1[x]>=nums2[y]) {
        			nums1[i] = nums1[x];
        			x--;
        		} else {
        			nums1[i] = nums2[y];
        			y--;
        		}
        	} else if (y<0) {
        		return;
        	} else {
        		nums1[i] = nums2[y];
        		y--;
        	}
        }
    }
}
