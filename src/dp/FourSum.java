package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum t=new FourSum();
		List<List<Integer>> ll=t.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
		for(List<Integer> l:ll){
			System.out.println(l.toString());
		}

	}
public List<List<Integer>> fourSum(int[] num, int target) {
	List<List<Integer>> res=new LinkedList<List<Integer>>();
	if(num==null||num.length<4){
		return res;
	}
	Arrays.sort(num);
	int l=0;
	int r=0;
	for(int i=0;i<num.length;i++){
		for(int j=i+1;j<num.length;j++){
			int sum=0;
			l=j+1;
			r=num.length-1;
			while(l<r){
				sum=num[l]+num[r]+num[i]+num[j];				
				if(sum==target){
					List<Integer> list=new LinkedList<Integer>();
					list.add(num[i]);
					list.add(num[j]);
					list.add(num[l]);
					list.add(num[r]);
					res.add(list);
					System.out.println(list.toString());
					System.out.println("l="+l+",r="+r);
					while(l+1<r&&num[l+1]==num[l]){
						l++;
					}
					l++;
					while(r-1>l&&num[r-1]==num[r]){
						r--;
					}
					r--;
					System.out.println("l="+l+",r="+r);
				}
				else if(sum<target){
					while(l+1<r&&num[l+1]==num[l]){
						l++;
					}
					l++;
				}
				else{
					while(r-1>l&&num[r-1]==num[r]){
						r--;
					}
					r--;
				}		
			}
			while(j+1<num.length&&num[j+1]==num[j]){
				j++;
			}
			System.out.println("l="+l+",r="+r+",j="+j);
			
		}
		while(i+1<num.length&&num[i+1]==num[i]){
			i++;
		}
		System.out.println("l="+l+",r="+r+",i="+i);
		
	}
	return res;
    }

}
