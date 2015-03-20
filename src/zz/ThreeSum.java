//zz reviewed
package zz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res=new LinkedList<>();
		if(num==null || num.length<3){
			return res;
		}
		Arrays.sort(num);
		for(int i=0;i<num.length-2;i++){
			int first=num[i];//zz variable not used
			int comp=-first;
			int l=i+1;
			int r=num.length-1;
			while(l<r){
				if(num[l]+num[r]==comp){
					List<Integer> list=new LinkedList<>();
					list.add(first);
					list.add(num[l]);
					list.add(num[r]);
					res.add(list);
					l++;
					while(l<num.length && num[l]==num[l-1]){
						l++;
					}
					r--;
					while(r>=0 && num[r]==num[r+1]){
						r--;
					}
				}
				else if(num[l]+num[r]<comp){
					l++;
					while(l<num.length && num[l]==num[l-1]){
						l++;
					}
				}
				else{
					r--;
					while(r>=0 && num[r]==num[r+1]){
						r--;
					}
				}
			}
			while(i+1<num.length && num[i]==num[i+1]){
				i++;
			}
		}
		return res;
	}
//	public List<List<Integer>> threeSum_wz(int[] num) {
//        List<List<Integer>> res = new LinkedList>();
//        if(num == null || num.length < 3){
//            return res;
//        }
//        Arrays.sort(num);
//        for(int i=0;i<=num.length-3;i++){
//            int j = i+1;
//            int k = num.length-1;
//            while(j<k){
//                int sum = num[i]+num[j]+num[k];
//                if(sum <0) j++;
//                else if(sum>0) k--;
//                else{
//                    List<Integer> list = new LinkedList<>();
//                    list.add(num[i]);list.add(num[j]);list.add(num[k]);
//                    res.add(list);
//                    j++;
//                    while(j<k && num[j]==num[j-1]) j++;
//                    k--;
//                    while(j<k && num[k] == num[k+1]) k--;
//                }
//                while(i+1<num.length && num[i]==num[i+1]) i++;
//            }
//        }
//        return res;
//    }
}
