package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] twoSum(int[] numbers, int target) {
        if (numbers==null){
        	return null;
        }
        int[] res=new int[2];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
        	map.put(target-numbers[i], i+1);
        }
        for (int j=0;j<numbers.length;j++){
        	if (map.containsKey(numbers[j])&&map.get(numbers[j])>j+1){
        		res[0]=j+1;
        		res[1]=map.get(numbers[j]);
        	}
        }
        return res;
    }
}
