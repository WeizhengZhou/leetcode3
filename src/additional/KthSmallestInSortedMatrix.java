package additional;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (k<=0 || matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) return 0;
        int n=matrix.length;
        int m=matrix[0].length;
        Map<Integer,Integer> map=new HashMap<> ();
       
        String s="asd";
        s.indexOf('a'+1);
        PriorityQueue<int[]> q=new PriorityQueue<> (k, new Comparator<int[] > () {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}});
        for (int i=0;i<m;i++) {
        	q.add(new int[] {matrix[0][i], 0, i});
        }
        int kth=0;
        for (int i=0;i<k;i++) {
        	int[] cur=q.poll();
        	kth=cur[0];
        	if (cur[1]+1<n) q.add(new int[] {matrix[cur[1]+1][cur[2]], cur[1]+1,cur[2]});
        }
        return kth;
    }
}
