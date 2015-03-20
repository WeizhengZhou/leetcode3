package xx;
import java.util.*;
public class ThreeSumCloset {
	public int threeSumClosest(int[] num, int target) {
		if(num==null || num.length<3){return 0;}
		Arrays.sort(num);
		int curSum=Integer.MAX_VALUE;
		int closeSum=Integer.MAX_VALUE-target;
		for(int i=0;i<num.length-2;i++){
			int l=i+1;
			int r=num.length-1;
			while(l<r){
				curSum=num[i]+num[l]+num[r];
				if(curSum==target){return target;}
				else if(Math.abs(curSum-target)<Math.abs(closeSum-target)){
					closeSum=curSum;
				}
				else if(curSum<target){
					l++;
				}
				else{
					r--;
				}
			}
		}
		return closeSum;

	}
}
