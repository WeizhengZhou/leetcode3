package zz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> res=new LinkedList<>();
		if(num==null || num.length<4){
			return res;
		}
		Arrays.sort(num);
		int n=num.length;
		for(int i=0;i<n-3;i++){
			for(int j=i+1;j<n-2;j++){
				int l=j+1;
				int r=n-1;
				int partSum=num[i]+num[j];
				while(l<r){
					int sum=partSum+num[l]+num[r];
					if(sum==target){
						List<Integer> list=new LinkedList<>();
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[l]);
						list.add(num[r]);
						res.add(list);
					}
					else if(sum<target){
						while(l+1<n && num[l+1]==num[l]){
							l++;
						}
						l++;
					}
					else{
						while(r-1>=0 && num[r-1]==num[r]){
							r--;
						}
						r--;
					}
				}
				while(j+1<n && num[j]==num[j+1]){
					j++;
				}
			}
			while(i+1<n && num[i]==num[i+1]){
				i++;
			}
		}
		return res;
	}

}
