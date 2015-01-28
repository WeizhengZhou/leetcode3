package zz;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] twoSum(int[] numbers, int target) {
		if(numbers==null || numbers.length<2){
			return null;
		}
		int index1=0;
		int index2=0;
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<numbers.length;i++){
			map.put(target-numbers[i], i);
		}
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(numbers[i])&&map.get(numbers[i])!=i){
				int j=map.get(numbers[i]);
				index1=Math.min(i, j);
				index2=Math.max(i, j);
			}
		}
		return new int[]{index1+1,index2+1};
	}

}
