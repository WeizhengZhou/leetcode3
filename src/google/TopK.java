import java.util.*;

public class TopK {
	public List<Integer> topK(List<Integer> list, int k){
		if(list == null || list.size() <= k) return list;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		Iterator<Integer> it = list.iterator();
		for(int i=0;i<k;i++){
			maxHeap.add(it.next());
		}
		while(it.hasNext()){
			int value = it.next();
			if(value < maxHeap.peek()){
				maxHeap.remove();
				maxHeap.add(value);
			}
		}
		System.out.println(maxHeap);
		return new ArrayList<>(maxHeap);
	}
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>();
		long seed = 1;
		Random rd = new Random(seed);
		for(int i=0;i<1000;i++){
			list.add(rd.nextInt(1000));
		}
		TopK solu = new TopK();
		solu.topK(list, 10);
	}
}
