package gogo;

import java.util.Arrays;
// have better solution O(n) time O(1) space
public class WiggleSort {
	
	public static void main(String[] args) {
		WiggleSort w=new WiggleSort();
		int[] a =new int[] {1, 3, 2, 2, 1};
		w.wiggleSort(a);
		System.out.println(Arrays.toString(a));
	}
	public void wiggleSort(int[] nums) {
		//13221
		//21312
		//12312
		//13212
		//12132
		//23121
		//11223
		//12123
		if (nums==null || nums.length<=1) return;
		Arrays.sort(nums);
		int m=nums.length/2;
		if (nums.length%2==1)m++;
		int[] small=Arrays.copyOf(nums, m);
		int[] large=Arrays.copyOfRange(nums, m,nums.length);
		int index=0;
		int iL=large.length-1;
		int iM=small.length-1;
		while(iL>=0 && iM>=0) {
			nums[index++]=small[iM--];
			nums[index++]=large[iL--];
		}
		if(iM>=0) nums[index++]=small[iM--];
	}
}
