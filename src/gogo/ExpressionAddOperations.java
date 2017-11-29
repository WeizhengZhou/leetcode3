package gogo;

import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperations {
    public List<String> addOperators(String num, int target) {
        List<String> list=new LinkedList<> ();
        if (num==null || num.length()==0) return list;
        helper(0,1,num, "", target,list, 1);
        return list;
    }
    private void helper(int index,long cur, String num, String s, long target,List<String> list,long pre) {
    	if (index==num.length()) {
    		if (cur==target) {
    			list.add(s);
    			return;
    		}
    	}
    	long sum=0;
    	for(int i=index;i<num.length();i++) {
    		if (i!=index && num.charAt(index)=='0') {
    			continue;
    		}
    		sum=sum*10+num.charAt(i)-'0';
    		String value= String.valueOf(sum);
    		if (index==0) {
    			helper(i+1,sum,num,value,target,list,sum);
    		} else {
    			helper(i+1,cur+sum,num,s+"+"+value,target,list,sum);
    			helper(i+1,cur-sum,num,s+"-"+value,target,list,-sum);
    			helper(i+1,cur-pre+pre*sum,num,s+"*"+value,target,list,pre*sum);
    		} 		
    	}
    }
}
