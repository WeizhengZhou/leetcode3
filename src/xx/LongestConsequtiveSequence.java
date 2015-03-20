package xx;

public class LongestConsequtiveSequence {
	 public int longestConsecutive(int[] num) {
         if(num==null || num.length==0)return 0;
         Set<Integer> set=new HashSet<>();
         for(int i=0;i<num.length;i++){
             set.add(num[i]);
         }
         int max=0;
         for(int j=0;j<num.length;j++){
             if(set.isEmpty())break;
             if(set.contains(num[j])){
                 int cur=num[j];
                 int i=cur+1;
                 int len=1;
                 while(set.contains(i)){
                     set.remove(i++);
                     len++;
                 }
                 i=cur-1;
                 while(set.contains(i)){
                     set.remove(i--);
                     len++;
                 }
                 max=Math.max(len,max);
             }
         }
         return max;
  }
}
