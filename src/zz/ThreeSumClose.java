package zz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumClose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int threeSumClosest(int[] num, int target) {
			if(num==null || num.length<3){
				return 0;
			}
			Arrays.sort(num);
			int min=Integer.MAX_VALUE;
			int close=Integer.MAX_VALUE;
			for(int i=0;i<num.length-2;i++){
				int first=num[i];
				int comp=target-first;
				int l=i+1;
				int r=num.length-1;
				while(l<r){
					if(Math.abs(comp-num[l]-num[r])<min){
						min=Math.abs(comp-num[l]-num[r]);
						close=first+num[l]+num[r];
					}
					if(num[l]+num[r]<comp){						
						l++;
					}
					else if((num[l]+num[r]>comp)){
						r--;
					}
					else{
						return target;
					}
				}
			}
			return close;
	 }

}
