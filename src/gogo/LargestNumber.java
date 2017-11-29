package gogo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums==null || nums.length==0) return "";
        
        Integer[] list = new Integer[nums.length];
        for (int i=0;i<nums.length;i++){
        	list[i]=nums[i];
        }
        Arrays.sort(list,new Comparator<Integer> () {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				int div1=10;
				int div2=10;
				while(o1/div1>0){
					div1*=10;
				}
				while(o2/div2>0) {
					div2*=10;
				}
				return -(o1*div2+o2-o2*div1-o1);
			}
        	
        });
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<list.length;i++){
        	sb.append(list[i]);
        }
        if (sb.charAt(0)=='0') return "0";
        return sb.toString();
    }
}
