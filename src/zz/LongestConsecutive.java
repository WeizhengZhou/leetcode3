//zz reviewed

package zz;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public int longestConsecutive(int[] num) {
		   if(num==null || num.length==0){
			   return 0;
		   }
		   Set<Integer> set=new HashSet<Integer>();
		   for(int i=0;i<num.length;i++){
			   set.add(num[i]);
		   }
		   int max=0;
		   int len=0;
		   for(int i=0;i<num.length;i++){
			   if(set.contains(num[i])){
				   len=1;
				   int cur=num[i];
				   while(set.contains(cur+1)){
					   len++;
					   set.remove(cur+1);
					   cur++;
				   }
				   cur=num[i];
				   while(set.contains(cur-1)){
					   len++;
					   set.remove(cur-1);
					   cur--;
				   }
				   max=Math.max(max, len);
			   }
		   }
		   return max;
	   }

}
