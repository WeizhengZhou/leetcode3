package xx;
import java.util.*;
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		if(numbers==null || numbers.length<2)return null;
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<numbers.length;i++){
			map.put(target-numbers[i],i);
		}
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(numbers[i]) && map.get(numbers[i])!=i){
				return new int[]{i+1,map.get(numbers[i])+1};
			}
		}
		return null;
	}
}
