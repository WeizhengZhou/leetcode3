package additional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ZeroSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZeroSubarrays z=new ZeroSubarrays();
		System.out.println(z.getZeroSubarray(new int[]{0,-1,1,2,3,-3}));
	}
	
	public int getZeroSubarray(int[] A){
		int sum=0;
		int n=0;
		Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
		for(int i=0;i<A.length;i++){
			sum+=A[i];
			System.out.println("sum="+sum);
			if(!map.containsKey(sum)){
				if(sum==0){
					n++;
				}
				map.put(sum, new LinkedList<Integer>());
			}
			else{
				n+=map.get(sum).size();
			}
			map.get(sum).add(i);
		}
		return n;
	}

}
