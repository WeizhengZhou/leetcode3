package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> threeSum(int[] num) {
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
