package additional;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArrayIntersectionII {
	public static void main(String[] args) {
		ArrayIntersectionII a=new ArrayIntersectionII();
		System.out.println(Arrays.toString(a.intersect(new int[] {1,2,2,1}, new int[] {2,2})));
	}
    public int[] intersect(int[] nums1, int[] nums2) {
    	if (nums1==null || nums1.length==0 || nums2==null || nums2.length==0) return new int[0];
    	Map<Integer, Integer> map=new HashMap<> ();
    	for(int i:nums1) {
    		if (map.containsKey(i)) {
    			map.put(i, map.get(i)+1);
    		} else {
    			map.put(i, 1);
    		}
    	}
    	List<Integer> list=new LinkedList<> ();
    	for(int i:nums2) {
    		if (map.containsKey(i)) {
    			list.add(i);
    			int fre=map.get(i);
    			if (fre==1) {
    				map.remove(i);
    			} else {
    				map.put(i, fre-1);
    			}
    		}
    	}
    	int [] r=new int[list.size()];
    	int i=0;
    	for(int n:list){
    		r[i++]=n;
    	}
    	return r;
    }
}
