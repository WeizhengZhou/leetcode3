package additional;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FIndKPairsWSmallestSum {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int []> list=new LinkedList<> ();
		if (k<=0 || nums1==null || nums1.length==0 || nums2==null || nums2.length==0) return list;
		PriorityQueue<int[]> q=new PriorityQueue<> (k,new Comparator<int[]> () {
		
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]+o1[1]-o2[0]-o2[1];
			}});
		for (int i=0;i<nums1.length;i++) {
			q.add(new int[] {nums1[i],nums2[0],0});
		}       
		for(int i=0;i<k && i< nums1.length*nums2.length;i++) {
			int[] top=q.poll();
			list.add(new int[] {top[0],top[1]});
			if (top[2]+1<nums2.length) {
				q.add(new int[] {top[0], nums2[top[2]+1], top[2]+1});
			}
		}
		return list;
    }
}
