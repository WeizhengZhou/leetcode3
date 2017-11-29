package additional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {
	public static void main(String[] args) {
		ArrayIntersection a = new ArrayIntersection();
		int[] r=a.intersection(new int[] {1, 2, 2, 1}, new int[] {2,2});
		System.out.println(Arrays.toString(r));
	}
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1==null || nums1.length==0 || nums2==null || nums2.length==0) return new int[0];
        Set<Integer> s1=new HashSet<> ();
        Set<Integer> inter=new HashSet<> ();
        for(int i:nums1) {
        	s1.add(i);
        }
        for(int i:nums2) {
        	if (s1.contains(i)) inter.add(i);
        }
        int [] r=new int[inter.size()];
        int i=0;
        for(int n:inter){
        	r[i++] = n;
        }
        return r;
    }
}
