package xx;
import ajva.util.*;
public class ThreeSum {
	 public List<List<Integer>> threeSum(int[] num) {
			List<List<Integer>> res=new LinkedList<>();
			if(num==null || num.length==0)return res;
			Arrays.sort(num);
			for(int i=0;i<num.length-2;i++){
			    int n1=num[i];
			    int l=i+1;
			    int r=num.length-1;
			    while(l<r){
			        if(n1+num[l]+num[r]==0){
			            List<Integer> buf=new LinkedList<>();
			            buf.add(n1);
			            buf.add(num[l]);
			            buf.add(num[r]);
			            res.add(buf);
			            l++;
			            while(l<num.length && num[l]==num[l-1])l++;
			            r--;
			            while(r>=0 && num[r]==num[r+1])r--;
			        }
			        else if(n1+num[l]+num[r]<0){
			            l++;
			            while(l<num.length && num[l]==num[l-1])l++;
			        }
			        else{
			            r--;
			            while(r>=0 && num[r]==num[r+1])r--;
			        }
			    }
			    while(i+1<num.length && num[i+1]==n1)i++;
			}
			return res;
	    }
}
