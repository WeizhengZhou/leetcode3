package gogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FlightTicketCost {
	public static void main(String[] args) {
		FlightTicketCost f=new FlightTicketCost();
		String[] flights=new String[] {"A->B,100","B->C,100","A->C,400"};
		System.out.println(f.getMinCost(flights, "A", "C", 0));
		
		Integer[] a={3,2,1,4};
        Arrays.sort(a,(x,y)->y-x);
        System.out.println(Arrays.toString(a));
        PriorityQueue<Map.Entry<String,Integer>> q=new PriorityQueue<> ();

	}
	public int getMinCost(String[] flights, String start, String des, int k) {
		Map<String, Integer> flightMap=new HashMap<> ();
		List<int []> costA=new ArrayList<> ();
		int count=0;
		for(String s:flights) {
			String[] part=s.split(",");
			String place=part[0];
			String[] places=place.split("->");
			String from=places[0];
			String to=places[1];
			if (!flightMap.containsKey(from)) {
				flightMap.put(from, count++);				
			}
			if (!flightMap.containsKey(to)) {
				flightMap.put(to, count++);				
			}
			int cost=Integer.parseInt(part[1]);
			costA.add(new int[] {flightMap.get(from), flightMap.get(to), cost});
		}
		int[][] cost=new int[count][count];
		for(int[] a:costA) {
			cost[a[0]][a[1]]=a[2];
		}
		Map<Integer, Integer> minCost=new HashMap<> ();
		minCost.put(flightMap.get(start),0);
		int destination=flightMap.get(des);
		Queue<Integer> cur=new LinkedList<> ();
		Queue<Integer> next=new LinkedList<> ();
		cur.add(flightMap.get(start));
		int times=0;
		while(!cur.isEmpty()) {
			int p=cur.poll();
			for(int i=0;i<count;i++) {
				int min=minCost.containsKey(i)?minCost.get(i):Integer.MAX_VALUE;
				int newC=minCost.get(p)+cost[p][i];
				if (min>newC) {
					minCost.put(i, newC);
					next.add(i);
				}
			}
			if (cur.isEmpty()) {
				if (times<k) {
					cur=new LinkedList<> (next);
					next.clear();
				}
				times++;
			}
		}
		return minCost.containsKey(destination) ? minCost.get(destination) : -1;
	}
}






