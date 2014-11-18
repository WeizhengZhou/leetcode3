package dp;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int longestConsecutive(int[] num) {
        if (num==null||num.length==0){
        	return 0;
        }
        int max=1;
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0; i<num.length; i++){
        	set.add(num[i]);
        }
        for(int j=0;j<num.length;j++){
        	if(set.contains(num[j])){
        		int len=1;
        		int n=num[j];
        		while(set.contains(n+1)){
        			len++;
        			set.remove(n+1);
        			n++;
        		}
        		int m=num[j];
        		while(set.contains(m-1)){
        			len++;
        			set.remove(m-1);
        			m--;
        		}
        		max=Math.max(len, max);
        	}
        }
        return max;
    }

}
