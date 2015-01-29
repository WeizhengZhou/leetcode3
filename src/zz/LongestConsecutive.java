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
		   Set<Integer> set=new HashSet<Integer>();//zz consider num has duplicates, will set return correct result?
		   for(int i=0;i<num.length;i++){
			   set.add(num[i]);
		   }
		   int max=0;//zz max_conseq_len
		   int len=0;
		   for(int i=0;i<num.length;i++){
		           //zz if(!set.contains(num[i])) continue;
			   //zz to avoid this large if block
			   if(set.contains(num[i])){//zz did you delete the num[i] itselft
		
				   len=1;
				   int cur=num[i];//zz why not cur = num[i]+1, 
						  //while(set.contains(cur)){len++;set.remove(cur++);}
						  //OR
						  //cur=num[i];while(set.contains(cur){len++;set.remove(cur++);})
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
