package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumClose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumClose t=new ThreeSumClose();
		System.out.println(t.threeSumClosest(new int[]{1,1,-1,-1,3}, -1));
	}
	
    public int threeSumClosest(int[] num, int target) {
    	if(num==null||num.length<3){
    		return 0;
    	}
    	Arrays.sort(num);
    	int close=num[0]+num[1]+num[2];
    	for(int i=0;i<num.length;i++){
    		int l=i+1;
    		int r=num.length-1;
    		int sum=0;
    		while(l<r){
    			sum=num[i]+num[l]+num[r];
    			if(Math.abs(sum-target)<Math.abs(close-target)){
    				close=sum;
    			}
    			if(sum<target){
    				l++;
    			}
    			else if(sum>target){
    				r--;
    			}
    			else{
    				break;
    			}
    		}
    	}
    	return close;
    }

}
