package xx;
import java.util.*;

public class FourSum {
	 public List<List<Integer>> fourSum(int[] num, int target) {
 		 List<List<Integer>> res=new LinkedList<>();
 		 if(num==null||num.length<4)return res;
 		 Arrays.sort(num);
 		 for(int i=0;i<=num.length-4;i++){
 		     int n1=num[i];
 		     for(int j=i+1;j<num.length;j++){
 		         int n2=num[j];
 		         int l=j+1;
 		         int r=num.length-1;
 		         while(l<r){
 		             if(n1+n2+num[l]+num[r]==target){
 		                 List<Integer> buf=new LinkedList<>();
 		                 buf.add(n1);
 		                 buf.add(n2);
 		                 buf.add(num[l]);
 		                 buf.add(num[r]);
 		                 res.add(buf);
 		                 l++;
 		                 while(l<num.length && num[l]==num[l-1]){l++;}
 		                 r--;
 		                 while(r>=0 && num[r]==num[r+1]){r--;}
 		             }
 		             else if(n1+n2+num[l]+num[r]<target){
 		                 l++;
 		                 while(l<num.length && num[l]==num[l-1]){l++;}
 		             }
 		             else{
 		                 r--;
 		                 while(r>=0 && num[r]==num[r+1]){r--;}
 		             }
 		         }
 		         while(j+1<num.length && num[j]==num[j+1]){j++;}
 		     }
 		     while(i+1<num.length && num[i]==num[i+1]){i++;}
 		 }
 		 return res;
    }
}
