import java.util.*;

public class PairSmallerThanThreshold {
	public static void main(String[] args){
		int[] A = new int[]{1,1,2,3};
		int x = 4;
//		SortedSet<Integer> ss = new TreeSet<Integer>();
//		for(int i=0;i<A.length;i++)
//			ss.add(A[i]);
//		for(int i=0;i<A.length;i++){
//			int upper = x -A[i]+1;
//			Set<Integer> pairSet = ss.headSet(upper);
//			for(Integer pair:pairSet){
//				if(pair < x){
//					System.out.println("(" + A[i] + "," + pair + ")");
//				}
//			}
//		}
//		SortedMap<Integer, List<Integer>> map = new TreeMap<Integer,List<Integer>>();
//		for(int i=0;i<A.length;i++){
//			if(!map.containsKey(A[i])){
//				List<Integer> index = new ArrayList<>();
//				index.add(i);
//				map.put(A[i],index);
//			}
//			else{
//				List<Integer> index = map.get(A[i]);
//				index.add(i);
//			}
//		}
//		for(int i=0;i<A.length;i++){
//			int upperBound = x - A[i]+1;
//			Map<Integer,List<Integer>> pairMap = map.headMap(upperBound);
//			for(Map.Entry<Integer, List<Integer>> entry : pairMap.entrySet()){
//				for(Integer index : entry.getValue()){
//					if(i < index){
//						System.out.println("(" + A[i] + ", " + A[index] + ")");
//					}
//				}
//			}
//		}
		SortedSet<Integer> s = new TreeSet<>();
		Integer[] B = {5,1,4,3,2};
		s.addAll(Arrays.asList(B));
		System.out.println(s);
	}

}
