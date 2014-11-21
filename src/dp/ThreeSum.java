package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<List<Integer>> threeSum(int[] num){
		 List<List<Integer>> res=new LinkedList<List<Integer>>();
		 if(num==null||num.length<3){
			 return res;
		 }
		 Arrays.sort(num);
		 Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		 for(int i=0;i<num.length;i++){
			 map.put(-num[i], i);
		 }
		 for(int i=0;i<num.length;i++){
			 for(int j=i+1;j<num.length;j++){
				 int sum=num[i]+num[j];
				 if(map.containsKey(sum)&&map.get(sum)>j){
					 List<Integer> list=new LinkedList<Integer>();
					 list.add(num[i]);
					 list.add(num[j]);
					 list.add(-sum);
					 res.add(list);				 
				 }
				 while(j+1<num.length&&num[j]==num[j+1]){
					 j++;
				 }
			 }
			 while(i+1<num.length&&num[i]==num[i+1]){
				 i++;
			 }
		 }
		 return res;
	 }
	
    public List<List<Integer>> threeSum1(int[] num) {
    	List<List<Integer>> res=new LinkedList<List<Integer>>();
    	if(num==null||num.length==0){
    		return res;
    	}
    	Arrays.sort(num);
    	int cur=0;
    	int l=0;
    	int r=0;
    	for(int i=0;i<num.length;i++){
    		cur=-num[i];
    		l=i+1;
    		r=num.length-1;
    		while(l<r){
    			int sum=num[l]+num[r];
    			
    			if(sum==cur){
    				List<Integer> list=new LinkedList<Integer>();
    				list.add(num[i]);
    				list.add(num[l]);
    				list.add(num[r]);
    				res.add(list);
    				while(l+1<r&&num[l+1]==num[l]){
    					l++;
    				}
    				while(r-1>=l&&num[r-1]==num[r]){
    					r--;
    				}
    				
    			}
    			else if(sum<cur){
    				while(l+1<r&&num[l+1]==num[l]){
    					l++;
    				}
    			}
    			else{
    				while(r-1>=l&&num[r-1]==num[r]){
    					r--;
    				}
    			}
    			

    		}
    	}
    	return res;
    }
}
